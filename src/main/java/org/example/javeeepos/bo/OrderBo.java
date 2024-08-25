package org.example.javeeepos.bo;

import org.example.javeeepos.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface OrderBo {
    boolean saveOrder(Order order) throws SQLException, NamingException;
}
