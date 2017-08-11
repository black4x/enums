package com.example.enums.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class EventDTO {

    private Long id;

    @NotNull
    private String type;

    @JsonProperty("type")
    public String getTypeName() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
