package org.example.javeeepos.dao.impl;

import org.example.javeeepos.dao.CustomerDao;
import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(Customer customer) throws SQLException, NamingException {

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
    public boolean update(Customer customer) throws SQLException, NamingException {
        String sql = "UPDATE customer SET name = ? ,address = ? , tel = ? WHERE id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
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
    public boolean delete(String id) throws SQLException, NamingException {
        String sql = "DELETE FROM customer WHERE id = ?";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        try{
            return pstm.executeUpdate() >0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Customer get(String id) throws SQLException, NamingException {
        String sql = "SELECT * FROM customer WHERE id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,id);

        try {
            ResultSet resultSet =  pstm.executeQuery();
            while (resultSet.next()){
                return new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("tel")
                );
            }

        }catch (Exception e){
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getAll() throws SQLException, NamingException {

        try{
            String sql = "SELECT * FROM customer";
            PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();


            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("tel")
                ));
            }

            return customers;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
