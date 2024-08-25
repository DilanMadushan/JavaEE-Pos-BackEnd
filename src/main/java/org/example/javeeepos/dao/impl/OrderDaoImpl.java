package org.example.javeeepos.dao.impl;

import org.example.javeeepos.bo.OrderBo;
import org.example.javeeepos.bo.impl.OrderBoImpl;
import org.example.javeeepos.dao.OrderDao;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {

    OrderBo orderBo = new OrderBoImpl();
    @Override
    public boolean saveOrder(OrderDto orderDto) throws SQLException, NamingException {
        return orderBo.saveOrder(new Order(
                orderDto.getOrderId(),
                orderDto.getCusId(),
                orderDto.getDate()
        ));
    }
}
