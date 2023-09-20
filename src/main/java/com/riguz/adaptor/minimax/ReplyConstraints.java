package com.riguz.adaptor.minimax;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReplyConstraints {
    private String senderType;
    private String senderName;

    public ReplyConstraints(String senderType, String senderName) {
        this.senderType = senderType;
        this.senderName = senderName;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Override
    public String toString() {
        return "ReplyConstraints{" +
                "senderType='" + senderType + '\'' +
                ", senderName='" + senderName + '\'' +
                '}';
    }
}
