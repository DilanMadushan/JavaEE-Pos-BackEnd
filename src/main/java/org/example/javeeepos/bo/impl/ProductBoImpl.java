package org.example.javeeepos.bo.impl;

import org.example.javeeepos.bo.ProductBo;
import org.example.javeeepos.dto.ProductDto;

public class ProductBoImpl implements ProductBo {

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
    public ProductDto getProduct(String id) {
        return null;
    }
}
