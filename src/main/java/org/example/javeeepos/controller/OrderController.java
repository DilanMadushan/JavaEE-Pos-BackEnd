package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javeeepos.dao.OrderDao;
import org.example.javeeepos.dao.ProductDao;
import org.example.javeeepos.dao.impl.OrderDaoImpl;
import org.example.javeeepos.dao.impl.ProductDaoImpl;
import org.example.javeeepos.dto.OrderDetailsDto;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.util.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/order")
public class OrderController extends HttpServlet {

    OrderDao orderDao = new OrderDaoImpl();
    ProductDao productDao = new ProductDaoImpl();

    Connection connection  = null;
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

        try{
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSaved = orderDao.saveOrder(orderDto);
            if (isSaved) {

                productDao.updateProduct()

            }else{
                connection.rollback();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
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
