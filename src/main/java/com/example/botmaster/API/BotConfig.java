package com.example.botmaster.API;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BotConfig {
    private String id;
    private String BotTitle;
    private String authorID;
    private Date createdDate;

    public void setId(String id) {
        this.id = id;
    }

    public void setBotTitle(String botTitle) {
        BotTitle = botTitle;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
