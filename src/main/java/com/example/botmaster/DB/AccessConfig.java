package com.example.botmaster.DB;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Repository
public class AccessConfig {

    @Value("${spring.datasource.jdbc-url}")
    private String dbURL;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    public Connection connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, userName, password);
        return connection;
    }

    public void disconnectDB(Connection connection) throws SQLException {
        connection.close();
    }
}
