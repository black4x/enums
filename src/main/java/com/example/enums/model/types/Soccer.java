package com.example.enums.model.types;

import com.example.enums.model.EventType;

public enum Soccer implements EventType {

    GOAL("goal", "sports/soccer_goal.json"),
    INFO("info", "sports/soccer_info.json"),
    PENALTY("penalty", "sports/soccer_penalty.json");

    private String name;
    private String fileName;

    Soccer(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public Enum getEnum() {
        return this;
    }
}
