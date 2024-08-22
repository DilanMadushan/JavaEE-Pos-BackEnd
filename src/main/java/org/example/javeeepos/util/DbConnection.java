package org.example.javeeepos.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
    public static DbConnection dbConnection;

    public Connection connection;

    public DbConnection() throws NamingException, SQLException {
        InitialContext ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/pos");
        this.connection = dataSource.getConnection();
    }

    public static DbConnection getInstance() throws SQLException, NamingException {
        return (null==dbConnection) ? dbConnection = new DbConnection() :dbConnection;
    }
    public Connection getConnection(){
        return this.connection;
    }
}
