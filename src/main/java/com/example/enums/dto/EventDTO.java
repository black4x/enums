package com.example.enums.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class EventDTO {

    @NotNull
    private String type;

    @JsonProperty("type")
    public String getTypeName() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
