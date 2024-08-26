package org.example.javeeepos.bo.Custom;

import org.example.javeeepos.bo.SuperBo;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderBo extends SuperBo {
    boolean saveOrder(OrderDto orderDto) throws SQLException, NamingException;
}
