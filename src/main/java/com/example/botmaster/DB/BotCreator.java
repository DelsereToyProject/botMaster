package com.example.botmaster.DB;


import com.example.botmaster.API.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class BotCreator {

    private static AccessConfig accessConfig;

    public BotCreator(AccessConfig accessConfig) {
        this.accessConfig = accessConfig;
    }

    @Autowired
    public static Object createBot(BotConfig botConfig) throws SQLException {
        Connection conn = accessConfig.connectDB();
        PreparedStatement preparedStatement
                = conn.prepareStatement(
                "INSERT INTO AutoMasterDB.BOT" +
                        "(bot_author_id, bot_name, bot_repo, bot_schedule) " +
                        "VALUES (?, ?, ?, ?);"
        );

        System.out.println(botConfig.getAuthorID());
        preparedStatement.setString(1, botConfig.getAuthorID());
        preparedStatement.setString(2, botConfig.getBotTitle());
        preparedStatement.setString(3, botConfig.getRepo());
        preparedStatement.setString(4, botConfig.getSchedule());

        preparedStatement.executeUpdate();
        conn.close();
        return preparedStatement.getResultSet();
    }
}
