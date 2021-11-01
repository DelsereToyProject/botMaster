package com.example.botmaster.DB;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessConfig {

    @Value("spring.datasource.driver-class-name")
    private String dbClassName;
    @Value("spring.datasource.jdbc-url")
    private String dbURL;
    @Value("spring.datasource.username")
    private String userName;
    @Value("spring.datasource.password")
    private String password;

    @Bean
    public Connection connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, userName, password);
        return connection;

    }

    public void disconnectDB(Connection connection) throws SQLException {
        connection.close();
    }
}
