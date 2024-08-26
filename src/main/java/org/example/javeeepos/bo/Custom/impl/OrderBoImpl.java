package org.example.javeeepos.bo.Custom.impl;

import org.example.javeeepos.bo.Custom.OrderBo;
import org.example.javeeepos.dao.DaoFactory;
import org.example.javeeepos.dao.custom.OrderDao;
import org.example.javeeepos.dao.custom.impl.OrderDaoImpl;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;

public class OrderBoImpl implements OrderBo{

    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER);
    @Override
    public boolean saveOrder(OrderDto orderDto) throws SQLException, NamingException {
        return orderDao.save(new Order(
                orderDto.getOrderId(),
                orderDto.getCusId(),
                orderDto.getDate()
        ));
    }
}
