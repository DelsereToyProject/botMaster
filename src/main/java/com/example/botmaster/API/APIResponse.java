package com.example.botmaster.API;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class APIResponse {



    @GetMapping("/API")
    public Object PostBot() {
        BotConfig botConfig = new BotConfig();
        botConfig.setId("new");
        botConfig.setBotTitle("new Bot");
        botConfig.setAuthorID("11");
        botConfig.setCreatedDate(new Date());
        return botConfig;
    }
}
