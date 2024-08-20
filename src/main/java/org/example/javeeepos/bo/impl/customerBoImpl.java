package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.CustomerBo;
import org.example.javeeepos.dto.CustomerDTO;

import java.util.List;

public class customerBoImpl implements CustomerBo {
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public List<CustomerDTO> getCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public boolean DeleteCustomer(CustomerDTO customerDTO) {
        return false;
    }
}
