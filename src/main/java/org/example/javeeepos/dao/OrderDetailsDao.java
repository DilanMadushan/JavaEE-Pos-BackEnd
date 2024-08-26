package org.example.javeeepos.dao;

import org.example.javeeepos.entity.OrderDetails;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderDetailsDao {
    boolean saveOrderDetails(OrderDetails orderDetails) throws SQLException, NamingException;
}
