package com.example.botmaster.Schedule;

import com.example.botmaster.DB.AccessConfig;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

@Component
public class WorkScheduler {

    private static AccessConfig accessConfig;

    public WorkScheduler(AccessConfig accessConfig){
        this.accessConfig = accessConfig;
    }

    //@Scheduled(cron = "0 * * * * * ")
    public void executeSchedule() throws SQLException {
        //scan program for 1min
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getInstance());

        Connection conn = accessConfig.connectDB();
        PreparedStatement preparedStatement
                = conn.prepareStatement("SELECT * FROM AutoMasterDB.BOT");

        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("--------------------------------");
        while (resultSet.next()) {
            System.out.println("bot_id : "+ resultSet.getString("bot_id"));
            System.out.println("bot_author_id : "+ resultSet.getString("bot_author_id"));
            System.out.println("bot_name : "+ resultSet.getString("bot_name"));
            System.out.println("bot_repo : "+ resultSet.getString("bot_repo"));
            System.out.println("bot_created : "+ resultSet.getString("bot_created"));
            System.out.println("bot_schedule : "+ resultSet.getString("bot_schedule"));
            System.out.println("--------------------------------");


            if(isNeedToRun(calendar, resultSet.getString("bot_schedule"))){
                /*
                 * 쿠버에 쏴줘야함
                 * 일단 쏘고 일끝나면 죽이는 부분은 API 응답으로 구현
                 *  */

            }

        }
        preparedStatement.close();
        conn.close();
    }

    public boolean isNeedToRun(Calendar current, String bot_schedule){

        String[][] scheduled = new String[5][2];
        scheduled[0][1] = valueOf((current.get(Calendar.MINUTE)));
        scheduled[1][1] = valueOf((current.get(Calendar.HOUR)));
        scheduled[2][1] = valueOf((current.get(Calendar.DATE)));
        scheduled[3][1] = valueOf((current.get(Calendar.MONTH)));
        scheduled[4][1] = valueOf((current.get(Calendar.YEAR)));

        StringTokenizer bot_scheduleStringTokenizer = new StringTokenizer(bot_schedule, "|");
        int x = 0;
        while (bot_scheduleStringTokenizer.hasMoreTokens()){
            scheduled[x++][0] = bot_scheduleStringTokenizer.nextToken();
        }

        for ( int i = 0; i < 5; i++ ) {
            StringTokenizer scheduled_each = new StringTokenizer(scheduled[i][0], ",");
            while (scheduled_each.hasMoreTokens()){
                String eachNextToken = scheduled_each.nextToken();
                if(!eachNextToken.equals(scheduled[i][1]) || !eachNextToken.equals("*")) return false;
            }
        }
        return true;
    }
}