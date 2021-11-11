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
        return BotCreator.createBot(botConfig);
    }

    @GetMapping("/API/bot-info/")
    public Object GetBot() {
        return new BotConfig();
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
        return new RepoConfig();
    }

}
