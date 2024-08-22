package org.example.javeeepos.dao.impl;

import org.example.javeeepos.dao.CustomerDao;
import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean saveCustomer(Customer customer) throws SQLException, NamingException {

        System.out.println(customer.toString());

        String sql = "INSERT INTO customer VALUES(?,?,?,?)";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,customer.getId());
        pstm.setString(2,customer.getName());
        pstm.setString(3,customer.getAddress());
        pstm.setString(4,customer.getTel());

        try{
            return pstm.executeUpdate() >0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException, NamingException {
        String sql = "UPDATE customer SET name = ? ,address = ? , tel = ? WHERE id = ?";
        PreparedStatement pstm = DbConnection.getInstance().connection.prepareStatement(sql);
        pstm.setString(1,customer.getName());
        pstm.setString(2,customer.getAddress());
        pstm.setString(3,customer.getTel());
        pstm.setString(4,customer.getId());

        try{
            return pstm.executeUpdate()>0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, NamingException {
        String sql = "DELETE FROM customer WHERE id = ?";
        Connection connection = DbConnection.getInstance().connection;
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        try{
            return pstm.executeUpdate() >0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Customer getCustomer(String id) {
        return null;
    }
}
