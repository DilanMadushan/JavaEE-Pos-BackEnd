package org.example.javeeepos.dao;

import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderDao {
    boolean saveOrder(Order order) throws SQLException, NamingException;
}
