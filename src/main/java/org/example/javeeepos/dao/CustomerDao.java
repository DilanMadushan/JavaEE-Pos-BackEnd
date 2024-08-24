package org.example.javeeepos.dao;

import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    boolean saveCustomer(Customer customer) throws SQLException, NamingException;
    boolean updateCustomer(Customer customer) throws SQLException, NamingException;
    boolean deleteCustomer(String id) throws SQLException, NamingException;
    Customer getCustomer(String id) throws SQLException, NamingException;
    List<Customer> getAllCustomer() throws SQLException, NamingException;
}
