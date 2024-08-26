package org.example.javeeepos.dao.custom.impl;

import org.example.javeeepos.dao.SqlUtil;
import org.example.javeeepos.dao.custom.OrderDao;
import org.example.javeeepos.entity.Order;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    SqlUtil sqlUtil = new SqlUtil();
    @Override
    public boolean save(Order order) throws SQLException, NamingException {
        try{
            return sqlUtil.execute("INSERT INTO orders VALUES(?,?,?)",
                    order.getOrderId(),order.getCusId(),order.getDate());
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean update(Order customer) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        return false;
    }

    @Override
    public Order get(String id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public List<Order> getAll() throws SQLException, NamingException {
        return null;
    }

}
