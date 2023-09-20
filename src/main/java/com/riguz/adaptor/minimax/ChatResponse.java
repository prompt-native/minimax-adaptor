package com.riguz.adaptor.minimax;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.riguz.adaptor.prompt.FunctionCall;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ChatResponse {
    private String reply;
    private List<Choice> choices;
    private Usage usage;
    private String id;
    private FunctionCall functionCall;

    private Error baseResp;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public Error getBaseResp() {
        return baseResp;
    }

    public void setBaseResp(Error baseResp) {
        this.baseResp = baseResp;
    }

    @Override
    public String toString() {
        return "ChatResponse{" +
                "reply='" + reply + '\'' +
                ", choices=" + choices +
                ", usage=" + usage +
                ", id='" + id + '\'' +
                ", functionCall=" + functionCall +
                ", baseResp=" + baseResp +
                '}';
    }
}
