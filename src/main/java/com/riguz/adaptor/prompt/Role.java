package com.riguz.adaptor.prompt;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    @JsonProperty("user")
    USER,
    @JsonProperty("assistant")
    ASSISTANT,
    @JsonProperty("function")
    FUNCTION
}