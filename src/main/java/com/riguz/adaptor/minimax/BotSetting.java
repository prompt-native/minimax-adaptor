package com.riguz.adaptor.minimax;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BotSetting {
    private String botName;
    private String content;

    public BotSetting(String botName, String content) {
        this.botName = botName;
        this.content = content;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BotSetting{" +
                "botName='" + botName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
