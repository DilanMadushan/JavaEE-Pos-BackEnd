package org.example.javeeepos.dao.impl;

import org.example.javeeepos.dao.ProductDao;
import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Product;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }

    @Override
    public Customer getCustomer(String id) {
        return null;
    }
}
