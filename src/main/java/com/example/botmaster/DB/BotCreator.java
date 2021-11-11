package com.example.botmaster.DB;


import com.example.botmaster.API.BotConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BotCreator {

    private String driverClassName = "org.mariadb.jdbc.Driver";

    private String jdbcUrl;

    private String userName;

    private String password;

    public Object createBot(BotConfig botConfig) throws SQLException {
        System.out.println(jdbcUrl);
        System.out.println(userName);
        System.out.println(password);
        System.out.println("connect......");

        Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
        PreparedStatement preparedStatement
                = conn.prepareStatement(
                "INSERT INTO AutoMasterDB.BOT" +
                        "(bot_author_id, bot_name, bot_repo, bot_schedule) " +
                        "VALUES (?, ?, ?, ?);"
        );
        preparedStatement.setString(1, botConfig.getAuthorID());
        preparedStatement.setString(2, botConfig.getBotTitle());
        preparedStatement.setString(3, botConfig.getRepo());
        preparedStatement.setString(4, botConfig.getSchedule());

        preparedStatement.executeUpdate();
        String result = preparedStatement.getResultSet().toString();
        conn.close();
        return result;
    }
}
