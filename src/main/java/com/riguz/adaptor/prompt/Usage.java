package com.riguz.adaptor.prompt;

public class Usage {
    private int totolTokens;
    private int promptTokens;
    private int completionTokens;

    public Usage() {
    }

    public Usage(int totolTokens, int promptTokens, int completionTokens) {
        this.totolTokens = totolTokens;
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
    }

    public int getTotolTokens() {
        return this.totolTokens;
    }

    public void setTotolTokens(int totolTokens) {
        this.totolTokens = totolTokens;
    }

    public int getPromptTokens() {
        return this.promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getCompletionTokens() {
        return this.completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Usage totolTokens(int totolTokens) {
        setTotolTokens(totolTokens);
        return this;
    }

    public Usage promptTokens(int promptTokens) {
        setPromptTokens(promptTokens);
        return this;
    }

    public Usage completionTokens(int completionTokens) {
        setCompletionTokens(completionTokens);
        return this;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "totolTokens=" + totolTokens +
                ", promptTokens=" + promptTokens +
                ", completionTokens=" + completionTokens +
                '}';
    }
}