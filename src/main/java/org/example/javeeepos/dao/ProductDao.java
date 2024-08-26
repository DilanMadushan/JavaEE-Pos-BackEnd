package org.example.javeeepos.dao;

import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Product;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface ProductDao extends CrudDao<Product>{
//    boolean saveProduct(Product product) throws SQLException, NamingException;
//    boolean updateProduct(Product product) throws SQLException, NamingException;
//    boolean deleteProduct(String id) throws SQLException, NamingException;
//    Product getProduct(String id) throws SQLException, NamingException;

    boolean updateProductQty(Product product) throws SQLException, NamingException;
}
