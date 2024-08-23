package org.example.javeeepos.bo;

import org.example.javeeepos.dto.ProductDto;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface ProductBo {
    boolean saveProduct(ProductDto productDto) throws SQLException, NamingException;
    boolean updateProduct(ProductDto productDto) throws SQLException, NamingException;
    boolean deleteProduct(String id) throws SQLException, NamingException;
    ProductDto getProduct(String id) throws SQLException, NamingException;
}
