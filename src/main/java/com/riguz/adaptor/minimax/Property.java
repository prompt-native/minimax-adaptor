package com.riguz.adaptor.minimax;

public class Property {
    private final String type;
    private final String description;

    public Property(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Property{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
