package org.example.javeeepos.dao.custom.impl;

import org.example.javeeepos.dao.SqlUtil;
import org.example.javeeepos.dao.custom.OrderDetailsDao;
import org.example.javeeepos.entity.OrderDetails;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

    SqlUtil sqlUtil = new SqlUtil();

    @Override
    public boolean save(OrderDetails orderDetails) throws SQLException, NamingException {

        try {
            return sqlUtil.execute("INSERT INTO orderDetails VALUES(?,?,?,?)",
                    orderDetails.getOrderId(),orderDetails.getProId(),orderDetails.getQty(),orderDetails.getPrice());
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(OrderDetails customer) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        return false;
    }

    @Override
    public OrderDetails get(String id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public List<OrderDetails> getAll() throws SQLException, NamingException {
        return null;
    }
}
