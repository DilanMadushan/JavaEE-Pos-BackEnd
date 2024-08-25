package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.OrderBo;
import org.example.javeeepos.dao.OrderDao;
import org.example.javeeepos.dao.impl.OrderDaoImpl;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Order;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderBoImpl implements OrderBo{

    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public boolean saveOrder(OrderDto orderDto) throws SQLException, NamingException {
        return orderDao.saveOrder(new Order(
                orderDto.getOrderId(),
                orderDto.getCusId(),
                orderDto.getDate()
        ));
    }
}
