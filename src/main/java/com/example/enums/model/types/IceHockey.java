package com.example.enums.model.types;

import com.example.enums.model.EventType;

public enum IceHockey implements EventType {

    GOAL("goal", "sports/ice_hockey_goal.json"),
    INFO("info", "sports/ice_hockey_info.json");

    private String name;
    private String fileName;

    IceHockey(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
