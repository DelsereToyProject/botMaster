package com.example.botmaster.API;


import com.example.botmaster.DB.BotCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;


@RestController
public class APIResponse {

    @PostMapping("/API/bot-info/")
    public Object PostNewBot(HttpServletRequest request) throws SQLException {
        HashMap<String, String> headerMap = getHeaderMap(request);
        BotConfig botConfig = new BotConfig(
                headerMap.get("id"),
                headerMap.get("userid"),
                headerMap.get("name"),
                headerMap.get("repo"),
                headerMap.get("schedule"));
        //TODO : return Message Module
        BotCreator.createBot(botConfig);
        return "PostNewBot";
    }

    @GetMapping("/API/bot-info/")
    public Object GetBot() {
        return new BotConfig();
    }


    @PostMapping("/API/user/")
    public Object registerNewOwner(HttpServletRequest request) {
        //TODO
        return new UserConfig();
    }

    @GetMapping("/API/user/")
    public Object getOwner(HttpServletRequest request) {
        return new UserConfig();
    }

    @PostMapping("/API/bot-repo/")
    public Object pushContainer(HttpServletRequest request) {

        //return new RepoConfig();
        return new UserConfig();
    }

    @PostMapping("/controller/ended-bot/")
    public Object PostEndSignal(HttpServletRequest request){
        HashMap<String, String> headerMap = getHeaderMap(request);
        RepoConfig repoConfig = new RepoConfig(
                headerMap.get("bot_id"),
                headerMap.get("bot_owner_id"),
                headerMap.get("bot_repo"),
                headerMap.get("repo_config"));

        return new Object();
    }


    @PostMapping("/controller/test-bot/")
    public Object PostTestSignal(HttpServletRequest request){
        System.out.println("DualService Test123");
        return "hello !!";
    }


    private HashMap<String, String> getHeaderMap(HttpServletRequest request){
        Enumeration<String> headers = request.getHeaderNames();
        HashMap<String, String> headerMap = new HashMap<>();
        while (headers.hasMoreElements()){
            String key = headers.nextElement();
            headerMap.put(key, request.getHeader(key));
        }
        return headerMap;
    }
}
