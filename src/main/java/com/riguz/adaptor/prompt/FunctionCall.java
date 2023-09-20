package com.riguz.adaptor.prompt;

public class FunctionCall {
    private String name;
    private String arguments;

    public FunctionCall() {
    }

    public FunctionCall(String name, String arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArguments() {
        return this.arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public FunctionCall name(String name) {
        setName(name);
        return this;
    }

    public FunctionCall arguments(String arguments) {
        setArguments(arguments);
        return this;
    }

    @Override
    public String toString() {
        return "FunctionCall{" +
                "name='" + name + '\'' +
                ", arguments='" + arguments + '\'' +
                '}';
    }
}