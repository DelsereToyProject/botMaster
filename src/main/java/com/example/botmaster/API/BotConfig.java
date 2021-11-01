package com.example.botmaster.API;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BotConfig {
    private String id;
    private String authorID;
    private String BotTitle;
    private String repo;
    private String schedule;

    public BotConfig(
            String id,
            String authorID,
            String BotTitle,
            String repo,
            String schedule){
        this.id = id;
        this.authorID = authorID;
        this.BotTitle = BotTitle;
        this.repo = repo;
        this.schedule = schedule;
    }

    public BotConfig(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setBotTitle(String botTitle) {
        BotTitle = botTitle;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getBotTitle() {
        return BotTitle;
    }

    public String getRepo() {
        return repo;
    }

    public String getSchedule() {
        return schedule;
    }
}
