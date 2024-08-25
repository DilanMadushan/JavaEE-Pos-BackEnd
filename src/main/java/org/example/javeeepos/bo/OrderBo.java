package org.example.javeeepos.bo;

import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderBo {
    boolean saveOrder(OrderDto orderDto) throws SQLException, NamingException;
}
