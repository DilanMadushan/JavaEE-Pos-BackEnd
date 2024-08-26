package org.example.javeeepos.bo;

import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.dto.ProductDto;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ProductBo {
    boolean saveProduct(ProductDto productDto) throws SQLException, NamingException;
    boolean updateProduct(ProductDto productDto) throws SQLException, NamingException;
    boolean deleteProduct(String id) throws SQLException, NamingException;
    ProductDto getProduct(String id) throws SQLException, NamingException;
    List<ProductDto> getAllProduct() throws SQLException, NamingException;
    boolean updateProductQty(ProductDto productDto) throws SQLException, NamingException;
}
