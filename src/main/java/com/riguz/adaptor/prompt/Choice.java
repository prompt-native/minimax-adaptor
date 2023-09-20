package com.riguz.adaptor.prompt;

public class Choice {
    private String finishReason;
    private Message message;
    
    public Choice(String finishReason, Message message) {
        this.finishReason = finishReason;
        this.message = message;
    }

    public String getFinishReason() {
        return this.finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Choice finishReason(String finishReason) {
        setFinishReason(finishReason);
        return this;
    }

    public Choice message(Message message) {
        setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "finishReason='" + finishReason + '\'' +
                ", message=" + message +
                '}';
    }
}