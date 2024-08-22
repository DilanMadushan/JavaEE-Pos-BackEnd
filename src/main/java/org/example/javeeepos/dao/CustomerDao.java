package org.example.javeeepos.dao;

import org.example.javeeepos.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    boolean saveCustomer(Customer customer) throws SQLException, NamingException;
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String id) throws SQLException, NamingException;
    Customer getCustomer(String id);
}
