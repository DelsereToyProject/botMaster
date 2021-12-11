package com.example.botmaster.API;

public class RepoConfig {

    private String bot_id; // equals Bot.bot_id
    private String bot_owner_id; // 봇 소유자
    private String bot_repo; // repo name
    private String repo_config; // 설정 (추가기능 구현시 필요)
    private boolean status = false;
    public RepoConfig(
            String bot_id,
            String bot_owner_id,
            String bot_repo,
            String repo_config) {
        this.bot_id = bot_id;
        this.bot_owner_id = bot_owner_id;
        this.bot_repo = bot_repo;
        this.repo_config = repo_config;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }
}