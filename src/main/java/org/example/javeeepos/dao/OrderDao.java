package org.example.javeeepos.dao;

import org.example.javeeepos.dto.OrderDto;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderDao {
    boolean saveOrder(OrderDto orderDto) throws SQLException, NamingException;
}
