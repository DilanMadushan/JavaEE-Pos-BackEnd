package org.example.javeeepos.dao.impl;

import org.example.javeeepos.bo.OrderDetailsBo;
import org.example.javeeepos.dao.OrderDetailsDao;
import org.example.javeeepos.dto.OrderDetailsDto;
import org.example.javeeepos.entity.OrderDetails;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Override
    public boolean saveOrderDetails(OrderDetails orderDetails) throws SQLException, NamingException {

        String sql = "INSERT INTO orderDetails VALUES(?,?,?,?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,orderDetails.getOrderId());
        pstm.setString(2,orderDetails.getProId());
        pstm.setDouble(3,orderDetails.getQty());
        pstm.setDouble(4,orderDetails.getPrice());

        try {
            return pstm.executeUpdate()>0;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
