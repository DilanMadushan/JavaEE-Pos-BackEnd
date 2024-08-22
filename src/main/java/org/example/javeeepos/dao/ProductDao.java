package org.example.javeeepos.dao;

import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Product;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface ProductDao {
    boolean saveProduct(Product product) throws SQLException, NamingException;
    boolean updateProduct(Product product);
    boolean deleteProduct(String id);
    Product getProduct(String id) throws SQLException, NamingException;
}
