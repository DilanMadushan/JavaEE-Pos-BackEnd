package org.example.javeeepos.dao;

import org.example.javeeepos.entity.Customer;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao{
    boolean save(T customer) throws SQLException, NamingException;
    boolean update(T customer) throws SQLException, NamingException;
    boolean delete(String id) throws SQLException, NamingException;
    T get(String id) throws SQLException, NamingException;
    List<T> getAll() throws SQLException, NamingException;
}
