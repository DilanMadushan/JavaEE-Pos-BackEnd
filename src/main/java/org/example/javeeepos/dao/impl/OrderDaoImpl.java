package org.example.javeeepos.dao.impl;

import org.example.javeeepos.bo.OrderBo;
import org.example.javeeepos.bo.impl.OrderBoImpl;
import org.example.javeeepos.dao.OrderDao;
import org.example.javeeepos.dto.OrderDto;
import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Order;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    @Override
    public boolean save(Order order) throws SQLException, NamingException {
        String sql = "INSERT INTO orders VALUES(?,?,?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,order.getOrderId());
        pstm.setString(2,order.getCusId());
        pstm.setDate(3, Date.valueOf(order.getDate()));

        try{
            return pstm.executeUpdate()>0;

        }catch (Exception e){
            return false;
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
