package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.example.javeeepos.bo.OrderBo;
import org.example.javeeepos.bo.OrderDetailsBo;
import org.example.javeeepos.bo.ProductBo;
import org.example.javeeepos.bo.impl.OrderBoImpl;
import org.example.javeeepos.bo.impl.OrderDetailsBoImpl;
import org.example.javeeepos.bo.impl.ProductBoImpl;
import org.example.javeeepos.dao.OrderDao;
import org.example.javeeepos.dao.ProductDao;
import org.example.javeeepos.dao.impl.OrderDaoImpl;
import org.example.javeeepos.dao.impl.ProductDaoImpl;
import org.example.javeeepos.dto.OrderDetailsDto;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.dto.ProductDto;
import org.example.javeeepos.util.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/order")
public class OrderController extends HttpServlet {

    Connection connection  = null;
    OrderBo orderBo = new OrderBoImpl();
    ProductBo productBo = new ProductBoImpl();

    OrderDetailsBo orderDetailsBo = new OrderDetailsBoImpl();
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


        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                try(var writer = resp.getWriter()){
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
                            boolean isDetailSaved = false;

                            for (OrderDetailsDto dto : detailsDto) {
                                isDetailSaved = orderDetailsBo.saveOrderDetails(dto);
                            }

                            System.out.println(isDetailSaved);

                            if (isDetailSaved) {
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
