package com.riguz.adaptor.minimax;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ChatRequest {
    private String model;
    private boolean stream;
    private Integer tokensToGenerate;
    private Float temperature;
    private Float topP;
    private Boolean maskSensitiveInfo;
    private List<Message> sampleMessages;
    private List<Message> messages;
    private List<BotSetting> botSetting;
    private ReplyConstraints replyConstraints;
    private List<Function> functions;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public Integer getTokensToGenerate() {
        return tokensToGenerate;
    }

    public void setTokensToGenerate(Integer tokensToGenerate) {
        this.tokensToGenerate = tokensToGenerate;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getTopP() {
        return topP;
    }

    public void setTopP(Float topP) {
        this.topP = topP;
    }

    public Boolean getMaskSensitiveInfo() {
        return maskSensitiveInfo;
    }

    public void setMaskSensitiveInfo(Boolean maskSensitiveInfo) {
        this.maskSensitiveInfo = maskSensitiveInfo;
    }

    public List<Message> getSampleMessages() {
        return sampleMessages;
    }

    public void setSampleMessages(List<Message> sampleMessages) {
        this.sampleMessages = sampleMessages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<BotSetting> getBotSetting() {
        return botSetting;
    }

    public void setBotSetting(List<BotSetting> botSetting) {
        this.botSetting = botSetting;
    }

    public ReplyConstraints getReplyConstraints() {
        return replyConstraints;
    }

    public void setReplyConstraints(ReplyConstraints replyConstraints) {
        this.replyConstraints = replyConstraints;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "ChatRequest{" +
                "model='" + model + '\'' +
                ", stream=" + stream +
                ", tokensToGenerate=" + tokensToGenerate +
                ", temperature=" + temperature +
                ", topP=" + topP +
                ", maskSensitiveInfo=" + maskSensitiveInfo +
                ", sampleMessages=" + sampleMessages +
                ", messages=" + messages +
                ", botSetting=" + botSetting +
                ", replyConstraints=" + replyConstraints +
                ", functions=" + functions +
                '}';
    }
}
