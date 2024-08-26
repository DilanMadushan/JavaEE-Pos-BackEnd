package org.example.javeeepos.bo.Custom.impl;

import org.example.javeeepos.bo.Custom.CustomerBo;
import org.example.javeeepos.dao.DaoFactory;
import org.example.javeeepos.dao.custom.CustomerDao;
import org.example.javeeepos.dao.custom.impl.CustomerDaoImpl;
import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDao.save(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTel()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException {
        return customerDao.update(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTel()
        ));
    }

    @Override
    public CustomerDTO getCustomer(String id) throws SQLException, NamingException {
        Customer customer = customerDao.get(id);
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getTel()
        );
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws SQLException, NamingException {
        List<Customer> customers =  customerDao.getAll();
        List<CustomerDTO> cusSet = new ArrayList<>();
        for(Customer cus: customers){
            cusSet.add(new CustomerDTO(
                    cus.getId(),
                    cus.getName(),
                    cus.getAddress(),
                    cus.getTel()
            ));
        }
        return cusSet;
    }

    @Override
    public boolean DeleteCustomer(String id) throws SQLException, NamingException {
        return customerDao.delete(id);
    }
}
