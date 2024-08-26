package org.example.javeeepos.dao;

import org.example.javeeepos.util.DbConnection;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {
    public <T> T execute(String sql,Object...objects) throws SQLException, NamingException {
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < objects.length; i++) {
            pstm.setObject(i+1,objects[i]);
        }

        if(sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        }else {
            return (T) (Boolean) (pstm.executeUpdate()>0);
        }
    }
}
