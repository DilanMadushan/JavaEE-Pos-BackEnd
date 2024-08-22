package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.CustomerBo;
import org.example.javeeepos.dao.CustomerDao;
import org.example.javeeepos.dao.impl.CustomerDaoImpl;
import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class customerBoImpl implements CustomerBo {

    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDao.saveCustomer(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTel()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDao.updateCustomer(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTel()
        ));
    }

    @Override
    public CustomerDTO getCustomer(String id) throws SQLException, NamingException {
        Customer customer = customerDao.getCustomer(id);
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getTel()
        );
    }

    @Override
    public boolean DeleteCustomer(String id) throws SQLException, NamingException {
        return customerDao.deleteCustomer(id);
    }
}
