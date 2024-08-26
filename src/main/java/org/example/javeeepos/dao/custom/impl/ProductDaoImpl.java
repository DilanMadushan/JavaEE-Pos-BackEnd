package org.example.javeeepos.dao.custom.impl;

import org.example.javeeepos.dao.SqlUtil;
import org.example.javeeepos.dao.custom.ProductDao;
import org.example.javeeepos.entity.Product;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    SqlUtil sqlUtil = new SqlUtil();
    @Override
    public boolean save(Product product) throws SQLException, NamingException {

        try{
            return sqlUtil.execute( "INSERT INTO product VALUES(?,?,?,?)",
                    product.getId(),product.getName(),product.getPrice(),product.getQty());

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Product product) throws SQLException, NamingException {

       try{
           return sqlUtil.execute( "UPDATE product SET name = ?,price = ?,qty = ? WHERE id = ?",
                   product.getName(),product.getPrice(),product.getQty(),product.getId());
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {

        try{
            return sqlUtil.execute("DELETE FROM product WHERE id = ?",id);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Product get(String id) throws SQLException, NamingException {

        try{
            ResultSet resultSet = sqlUtil.execute("SELECT * FROM product WHERE id = ?",id);

            while(resultSet.next()){
                return new Product(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("qty")
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAll() throws SQLException, NamingException {

        List<Product> products = new ArrayList<>();

        try{
            ResultSet resultSet = sqlUtil.execute("SELECT * FROM product");

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("qty")
                ));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean updateProductQty(Product product) throws SQLException, NamingException {

        try{
            return sqlUtil.execute("UPDATE product SET qty = qty - ? WHERE id = ? ",
                    product.getQty(),product.getId());
        }catch (Exception e){
            return false;
        }
    }
}
