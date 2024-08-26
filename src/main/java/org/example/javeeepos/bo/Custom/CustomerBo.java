package org.example.javeeepos.bo.Custom;

import org.example.javeeepos.bo.SuperBo;
import org.example.javeeepos.dto.CustomerDTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo {
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;
    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, NamingException;
    CustomerDTO getCustomer(String id) throws SQLException, NamingException;
    List<CustomerDTO> getAllCustomer() throws SQLException, NamingException;
    boolean DeleteCustomer(String id) throws SQLException, NamingException;
}
