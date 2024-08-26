package org.example.javeeepos.dao.impl;

import org.example.javeeepos.dao.ProductDao;
import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Product;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean save(Product product) throws SQLException, NamingException {
        String sql = "INSERT INTO product VALUES(?,?,?,?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, product.getId());
        pstm.setString(2, product.getName());
        pstm.setDouble(3, product.getPrice());
        pstm.setDouble(4, product.getQty());

        try{
            return pstm.executeUpdate() >0;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Product product) throws SQLException, NamingException {
       String sql = "UPDATE product SET name = ?,price = ?,qty = ? WHERE id = ?";
       PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
       pstm.setString(1,product.getName());
       pstm.setDouble(2,product.getPrice());
       pstm.setDouble(3,product.getQty());
       pstm.setString(4,product.getId());

       try{
           return pstm.executeUpdate() >0;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        String sql = "DELETE FROM product WHERE id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,id);

        try{
            return pstm.executeUpdate() >0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Product get(String id) throws SQLException, NamingException {
        String sql = "SELECT * FROM product WHERE id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,id);

        try{
            ResultSet resultSet = pstm.executeQuery();

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
        String sql = "SELECT * FROM product";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

        List<Product> products = new ArrayList<>();

        try{
            ResultSet resultSet = pstm.executeQuery();
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
        String sql = "UPDATE product SET qty = qty - ? WHERE id = ? ";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setDouble(1,product.getQty());
        pstm.setString(2,product.getId());

        try{
            return pstm.executeUpdate()>0;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
