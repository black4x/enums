package com.example.enums.model;

import com.fasterxml.jackson.annotation.JsonValue;

public interface EventType {
    String getFileName();

    @JsonValue
    String getName();

    Enum getEnum();
}
