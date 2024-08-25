package org.example.javeeepos.bo.impl;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
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
    public boolean saveProduct(ProductDto productDto) throws SQLException, NamingException {
       return productDao.saveProduct(new Product(
               productDto.getId(),
               productDto.getName(),
               productDto.getPrice(),
               productDto.getQty()
       ));
    }

    @Override
    public boolean updateProduct(ProductDto productDto) throws SQLException, NamingException {
        return productDao.updateProduct(new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQty()
        ));
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException, NamingException {
        return productDao.deleteProduct(id);
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

    @Override
    public boolean updateProductQty(ProductDto productDto) throws SQLException, NamingException {
        return productDao.updateProductQty(new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQty()
        ));
    }
}
