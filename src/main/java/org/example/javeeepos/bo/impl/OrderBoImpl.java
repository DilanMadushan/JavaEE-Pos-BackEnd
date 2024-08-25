package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.OrderBo;
import org.example.javeeepos.entity.Order;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderBoImpl implements OrderBo{
    @Override
    public boolean saveOrder(Order order) throws SQLException, NamingException {
        String sql = "INSERT INTO orders VALUES(?,?,?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,order.getOrderId());
        pstm.setString(2,order.getCusId());
        pstm.setDate(3, Date.valueOf(order.getDate()));

        try{
            return pstm.executeUpdate()>0;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
