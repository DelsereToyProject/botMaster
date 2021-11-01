package com.example.botmaster.API;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

@RestController
public class APIResponse {


    @PostMapping("/API/new-bot/")
    public Object PostNewBot(HttpServletRequest req) {

        HashMap<String, String> headerMap = getHeaderMap(req);
        BotConfig botConfig = new BotConfig(
                headerMap.get("id"),
                headerMap.get("userid"),
                headerMap.get("name"),
                headerMap.get("repo"),
                headerMap.get("schedule"));

        return botConfig;
    }

    @GetMapping("/API/bot-info")
    public Object GetBot() {
        return new BotConfig();
    }


    private HashMap<String, String> getHeaderMap(HttpServletRequest req){
        Enumeration<String> headers = req.getHeaderNames();
        HashMap<String, String> headerMap = new HashMap<>();
        while (headers.hasMoreElements()){
            String key = headers.nextElement();
            headerMap.put(key, req.getHeader(key));
        }
        return headerMap;
    }

}
