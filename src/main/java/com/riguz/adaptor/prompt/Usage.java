package com.riguz.adaptor.prompt;

public class Usage {
    private int totalTokens;
    private int promptTokens;
    private int completionTokens;

    public Usage(int totalTokens, int promptTokens, int completionTokens) {
        this.totalTokens = totalTokens;
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "totalTokens=" + totalTokens +
                ", promptTokens=" + promptTokens +
                ", completionTokens=" + completionTokens +
                '}';
    }
}