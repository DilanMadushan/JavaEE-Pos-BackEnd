package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.OrderDetailsBo;
import org.example.javeeepos.dao.OrderDetailsDao;
import org.example.javeeepos.dao.impl.OrderDetailsDaoImpl;
import org.example.javeeepos.dto.OrderDetailsDto;
import org.example.javeeepos.entity.OrderDetails;

import javax.naming.NamingException;
import java.sql.SQLException;

public class OrderDetailsBoImpl implements OrderDetailsBo {

    OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
    @Override
    public boolean saveOrderDetails(OrderDetailsDto orderDto) throws SQLException, NamingException {
        return orderDetailsDao.save(new OrderDetails(
                orderDto.getOrderId(),
                orderDto.getCusId(),
                orderDto.getProId(),
                orderDto.getQty(),
                orderDto.getPrice()
        ));
    }
}
