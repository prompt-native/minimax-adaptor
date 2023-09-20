package com.riguz.adaptor.minimax;

import java.util.List;
import java.util.Map;

public class FunctionParameter {
    private String type;
    private Map<String, Property> properties;
    private List<String> required;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "FunctionParameter{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                ", required=" + required +
                '}';
    }
}
