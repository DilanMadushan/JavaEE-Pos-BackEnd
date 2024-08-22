package org.example.javeeepos.dao;

import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Product;

public interface ProductDao {
    boolean saveProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(String id);
    Customer getCustomer(String id);
}
