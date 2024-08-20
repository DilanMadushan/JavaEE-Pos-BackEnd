package org.example.javeeepos.bo;

import org.example.javeeepos.dto.CustomerDTO;

import java.util.List;

public interface CustomerBo {
    boolean saveCustomer(CustomerDTO customerDTO);
    boolean updateCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomer(CustomerDTO customerDTO);
    boolean DeleteCustomer(CustomerDTO customerDTO);
}
