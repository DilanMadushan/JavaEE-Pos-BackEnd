package org.example.javeeepos.dao.custom.impl;

import org.example.javeeepos.dao.SqlUtil;
import org.example.javeeepos.dao.custom.UserDao;
import org.example.javeeepos.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    SqlUtil sqlUtil = new SqlUtil();
    @Override
    public boolean save(User user) throws SQLException, NamingException {
        try{
            return sqlUtil.execute("INSERT INTO user VALUES(?,?,?)",
                    user.getId(),user.getName(),user.getPassword());
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(User customer) throws SQLException, NamingException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, NamingException {
        return false;
    }

    @Override
    public User get(String id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException, NamingException {
        return null;
    }
}
