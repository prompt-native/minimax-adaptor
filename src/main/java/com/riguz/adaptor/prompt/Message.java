package com.riguz.adaptor.prompt;

public class Message {
    private Role role;
    private String name;
    private String content;
    private FunctionCall functionCall;

    public Message() {
    }

    public Message(Role role, String name, String content, FunctionCall functionCall) {
        this.role = role;
        this.name = name;
        this.content = content;
        this.functionCall = functionCall;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FunctionCall getFunctionCall() {
        return this.functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public Message role(Role role) {
        setRole(role);
        return this;
    }

    public Message name(String name) {
        setName(name);
        return this;
    }

    public Message content(String content) {
        setContent(content);
        return this;
    }

    public Message functionCall(FunctionCall functionCall) {
        setFunctionCall(functionCall);
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "role=" + role +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", functionCall=" + functionCall +
                '}';
    }
}