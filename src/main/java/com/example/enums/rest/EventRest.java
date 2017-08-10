package com.example.enums.rest;

import com.example.enums.dto.Event;
import com.example.enums.model.Category;
import com.example.enums.model.EventType;
import com.example.enums.model.types.IceHockey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EventRest {

    @PostMapping()
    public EventType createEvent(@Valid @RequestBody Event event) {
        return Category.get("ice_hockey").findByName(event.type);
    }

    @GetMapping
    public Event sendOneEvent() {
        Event event = new Event();
        event.type = IceHockey.GOAL.getName();
        return event;
    }

    @GetMapping(path = "/cat")
    public Map<String, EventType[]> getAllCategories() {
        Map<String, EventType[]> result = new HashMap<>();

        for (Category category : Category.values()) {
            result.put(category.getName(), category.getEventTypes());
        }

        return result;
    }

}
