package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.ProductBo;
import org.example.javeeepos.dao.ProductDao;
import org.example.javeeepos.dao.impl.ProductDaoImpl;
import org.example.javeeepos.dto.ProductDto;
import org.example.javeeepos.entity.Product;

import javax.naming.NamingException;
import java.sql.SQLException;

public class ProductBoImpl implements ProductBo {

    ProductDao productDao = new ProductDaoImpl();
    @Override
    public boolean saveProduct(ProductDto productDto) {
        return false;
    }

    @Override
    public boolean updateProduct(ProductDto productDto) {
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }

    @Override
    public ProductDto getProduct(String id) throws SQLException, NamingException {
        Product product = productDao.getProduct(id);
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQty()
        );
    }
}
