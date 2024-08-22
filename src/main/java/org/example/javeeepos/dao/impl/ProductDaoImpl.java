package org.example.javeeepos.dao.impl;

import org.example.javeeepos.dao.ProductDao;
import org.example.javeeepos.entity.Customer;
import org.example.javeeepos.entity.Product;
import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }

    @Override
    public Product getProduct(String id) throws SQLException, NamingException {
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
}
