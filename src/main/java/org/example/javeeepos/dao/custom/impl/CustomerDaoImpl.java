package org.example.javeeepos.dao.custom.impl;

import org.example.javeeepos.dao.SqlUtil;
import org.example.javeeepos.dao.custom.CustomerDao;
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

    SqlUtil sqlUtil = new SqlUtil();

    @Override
    public boolean save(Customer customer) throws SQLException, NamingException{

        try {
            return sqlUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",
                    customer.getId(),customer.getName(),customer.getAddress(),customer.getTel());
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Customer customer) throws SQLException, NamingException {
        try{
            return sqlUtil.execute("UPDATE customer SET name = ? ,address = ? , tel = ? WHERE id = ?",
                    customer.getName(),customer.getAddress(),customer.getTel(),customer.getId());
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        try{
            return sqlUtil.execute("DELETE FROM customer WHERE id = ?",id);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Customer get(String id) throws SQLException, NamingException {
        try {
            ResultSet resultSet =  sqlUtil.execute("SELECT * FROM customer WHERE id = ?",id);
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
            ResultSet resultSet = sqlUtil.execute("SELECT * FROM customer");


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
