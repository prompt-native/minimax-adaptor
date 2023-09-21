package com.riguz.adaptor.prompt;

import java.util.List;

public class FunctionParameter {
    private String name;
    private String type;
    private String description;
    private Boolean required;
    private List<String> enums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public List<String> getEnums() {
        return enums;
    }

    public void setEnums(List<String> enums) {
        this.enums = enums;
    }

    @Override
    public String toString() {
        return "FunctionParameter{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", required=" + required +
                ", enums=" + enums +
                '}';
    }
}
