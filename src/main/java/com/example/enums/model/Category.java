package com.example.enums.model;

import com.example.enums.model.types.IceHockey;
import com.example.enums.model.types.Soccer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum Category {

    ICE_HOCKEY("ice_hockey", Stream.of(IceHockey.values())),
    SOCCER("soccer", Stream.of(Soccer.values()));

    // Reverse-lookup map for getting a day from an abbreviation
    private static final Map<String, Category> lookup = new HashMap<>();

    static {
        for (Category category : Category.values()) {
            lookup.put(category.getName(), category);
        }
    }

    private Stream<EventType> typeStream;
    private String name;

    Category(String name, Stream<EventType> values) {
        this.name = name;
        this.typeStream = values;
    }

    public static Category get(String name) {
        lookup.computeIfAbsent(name, key -> {
            throw new IllegalArgumentException(key + " not found in categories");
        });
        return lookup.get(name);
    }

    public Stream<EventType> getTypeStream() {
        return typeStream;
    }

    public Optional<EventType> findByName(String name) {
        return this.typeStream.filter(x -> x.getName().equals(name)).findFirst();
    }

    public String getName() {
        return name;
    }
}
