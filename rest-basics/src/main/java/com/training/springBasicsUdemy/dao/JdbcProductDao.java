package com.training.springBasicsUdemy.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
public class JdbcProductDao implements  ProductDao{

    private String driverClassName;
    private String url;
    private String user;
    private String password;
    private Connection connection;


    private Connection createConnection() throws ClassNotFoundException, SQLException {

        if(connection!=null && connection.isClosed()==false)
        {
            return connection;
        }

        Class.forName(driverClassName);
        return DriverManager.getConnection(url, user, password);

    }



    @Override
    public long count() {
        try(
                Connection conn = createConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES");
                ResultSet rs = stmt.executeQuery();
                )
        {

            rs.next();
            return rs.getLong(1);
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
