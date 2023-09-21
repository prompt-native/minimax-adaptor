package com.riguz.adaptor.prompt;

import java.util.List;

public class Chat {
    private String version;
    private String engine;
    private String context;
    private List<Message> examples;
    private List<Message> messages;

    private List<Function> functions;
    private List<Parameter> parameters;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Message> getExamples() {
        return examples;
    }

    public void setExamples(List<Message> examples) {
        this.examples = examples;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "version='" + version + '\'' +
                ", engine='" + engine + '\'' +
                ", context='" + context + '\'' +
                ", examples=" + examples +
                ", messages=" + messages +
                ", functions=" + functions +
                ", parameters=" + parameters +
                '}';
    }
}