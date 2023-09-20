package com.riguz.adaptor.functions;

import com.riguz.adaptor.prompt.Choice;
import com.riguz.adaptor.prompt.Usage;

import java.util.List;

public class Output {
    private String externalId;
    private List<Choice> choices;
    private Usage usage;

    public Output() {
    }

    public Output(String externalId, List<Choice> choices, Usage usage) {
        this.externalId = externalId;
        this.choices = choices;
        this.usage = usage;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<Choice> getChoices() {
        return this.choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return this.usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public Output externalId(String externalId) {
        setExternalId(externalId);
        return this;
    }

    public Output choices(List<Choice> choices) {
        setChoices(choices);
        return this;
    }

    public Output usage(Usage usage) {
        setUsage(usage);
        return this;
    }
}
