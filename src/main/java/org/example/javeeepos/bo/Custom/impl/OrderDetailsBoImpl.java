package org.example.javeeepos.bo.Custom.impl;

import org.example.javeeepos.bo.Custom.OrderDetailsBo;
import org.example.javeeepos.dao.DaoFactory;
import org.example.javeeepos.dao.custom.OrderDetailsDao;
import org.example.javeeepos.dao.custom.impl.OrderDetailsDaoImpl;
import org.example.javeeepos.dto.OrderDetailsDto;
import org.example.javeeepos.entity.OrderDetails;

import javax.naming.NamingException;
import java.sql.SQLException;

public class OrderDetailsBoImpl implements OrderDetailsBo {

    OrderDetailsDao orderDetailsDao = (OrderDetailsDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDERDETAILS);
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
