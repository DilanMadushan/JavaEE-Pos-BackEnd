package org.example.javeeepos.dao;

import org.example.javeeepos.entity.Customer;

import java.util.List;

public interface CustomerDao {
    boolean saveCustomer();
    boolean updateCustomer();
    boolean deleteCustomer();
    List<Customer> getCustomer();
}
