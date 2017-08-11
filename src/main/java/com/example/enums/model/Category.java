package com.example.enums.model;

import com.example.enums.model.types.IceHockey;
import com.example.enums.model.types.Soccer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum Category {

    ICE_HOCKEY("ice_hockey", IceHockey.values()),
    SOCCER("soccer", Soccer.values());

    // Reverse-lookup map for getting a day from an abbreviation
    private static final Map<String, Category> lookup = new HashMap<>();

    static {
        for (Category category : Category.values()) {
            lookup.put(category.getName(), category);
        }
    }

    private String name;
    private EventType[] eventTypes;

    Category(String name, EventType[] eventTypes) {
        this.name = name;
        this.eventTypes = eventTypes;
    }

    @JsonCreator
    public static Category get(final String name) {
        if (name == null) throw new IllegalArgumentException("category name is null");
        lookup.computeIfAbsent(name, key -> {
            throw new IllegalArgumentException(key + " not found in categories");
        });
        return lookup.get(name);
    }

    public EventType findByName(final String name) {
        if (eventTypes == null) throw new IllegalArgumentException("category has no ");
        if (name == null) throw new IllegalArgumentException("event name is null");
        return Arrays.stream(this.eventTypes)
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("event type with name" + name + "not found"));
    }

    public String getEventName(Enum eventType) {
        return Arrays.stream(eventTypes)
                .filter(typeEnum -> typeEnum.equals(eventType))
                .findFirst().orElseThrow(() -> new NoSuchElementException("event enum with type" + eventType + "not found in category" + this))
                .getName();
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public EventType[] getEventTypes() {
        return eventTypes;
    }
}
