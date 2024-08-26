package org.example.javeeepos.bo.Custom.impl;

import org.example.javeeepos.bo.Custom.ProductBo;
import org.example.javeeepos.dao.DaoFactory;
import org.example.javeeepos.dao.custom.ProductDao;
import org.example.javeeepos.dao.custom.impl.ProductDaoImpl;
import org.example.javeeepos.dto.ProductDto;
import org.example.javeeepos.entity.Product;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo {

    ProductDao productDao = (ProductDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.PRODUCT);
    @Override
    public boolean saveProduct(ProductDto productDto) throws SQLException, NamingException {
       return productDao.save(new Product(
               productDto.getId(),
               productDto.getName(),
               productDto.getPrice(),
               productDto.getQty()
       ));
    }

    @Override
    public boolean updateProduct(ProductDto productDto) throws SQLException, NamingException {
        return productDao.update(new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQty()
        ));
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException, NamingException {
        return productDao.delete(id);
    }

    @Override
    public ProductDto getProduct(String id) throws SQLException, NamingException {
        Product product = productDao.get(id);
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQty()
        );
    }

    @Override
    public List<ProductDto> getAllProduct() throws SQLException, NamingException {
        List<Product> products =  productDao.getAll();
        List<ProductDto> productDto = new ArrayList<>();

        for (Product product : products) {
            productDto.add(new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQty()
            ));

        }
        return productDto;

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
