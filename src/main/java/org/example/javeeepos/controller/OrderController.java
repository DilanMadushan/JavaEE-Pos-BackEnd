package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.example.javeeepos.bo.BoFactory;
import org.example.javeeepos.bo.Custom.OrderBo;
import org.example.javeeepos.bo.Custom.OrderDetailsBo;
import org.example.javeeepos.bo.Custom.ProductBo;
import org.example.javeeepos.bo.Custom.impl.OrderBoImpl;
import org.example.javeeepos.bo.Custom.impl.OrderDetailsBoImpl;
import org.example.javeeepos.bo.Custom.impl.ProductBoImpl;
import org.example.javeeepos.dto.OrderDetailsDto;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.dto.ProductDto;
import org.example.javeeepos.util.DbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/order")
public class OrderController extends HttpServlet {

    Connection connection  = null;
    OrderBo orderBo = (OrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.ORDER);
    ProductBo productBo = (ProductBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.PRODUCT);
    OrderDetailsBo orderDetailsBo = (OrderDetailsBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.ORDERDETAILS);
    boolean isPlaced = false;

    static Logger logger = LoggerFactory.getLogger("OrderController");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        List<OrderDetailsDto> detailsDto = jsonb.fromJson(req.getReader(), new ArrayList<OrderDetailsDto>(){}.getClass().getGenericSuperclass());

        OrderDto orderDto = new OrderDto(
                detailsDto.get(0).getOrderId(),
                detailsDto.get(0).getCusId(),
                LocalDate.now()
        );

        List<ProductDto> productList = new ArrayList<>();

        for (OrderDetailsDto dto : detailsDto) {

            productList.add(new ProductDto(
                    dto.getProId(),
                    null,
                    0,
                    dto.getQty()
            ));
        }

        placeOrder(detailsDto,orderDto,productList);

        if (isPlaced) {
            resp.getWriter().println("Placed");
        }



    }

    public void placeOrder( List<OrderDetailsDto> detailsDto, OrderDto orderDto,List<ProductDto> productList){
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                try{
                    connection = DbConnection.getInstance().getConnection();
                    connection.setAutoCommit(false);

                    boolean isSaved = orderBo.saveOrder(orderDto);

                    if (isSaved) {
                        System.out.println("Saved");

                        boolean isUpdated = false;

                        for (ProductDto productDto : productList) {
                            isUpdated = productBo.updateProductQty(productDto);
                        }

                        if (isUpdated) {
                            System.out.println("Updated");
                            logger.info("Order Placed");
                            boolean isDetailSaved = false;

                            for (OrderDetailsDto dto : detailsDto) {
                                isDetailSaved = orderDetailsBo.saveOrderDetails(dto);
                            }

                            System.out.println(isDetailSaved);

                            if (isDetailSaved) {
                                isPlaced =  true;
                                connection.commit();
                            }else{
                                connection.rollback();
                            }


                        }else{
                            connection.rollback();
                        }

                    }else{
                        connection.rollback();
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    connection.setAutoCommit(true);
                }
            }
        }).start();

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
