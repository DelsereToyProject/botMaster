package com.example.botmaster.DB;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BotCreator {

    public void createBot(User user) throws SQLException {
        Connection conn = new AccessConfig().connectDB();
        PreparedStatement preparedStatement
                = conn.prepareStatement("INSERT INTO BOT(bot_name, bot_repo, bot_schedule) VALUES (?, ?, ?);");
        //test example : INSERT INTO BOT(bot_name, bot_repo, bot_schedule) VALUES ("testhello", "testhello/helloworld", "month");
    }

}
