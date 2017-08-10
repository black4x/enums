package com.example.enums.rest;

import com.example.enums.dto.Event;
import com.example.enums.model.Category;
import com.example.enums.model.EventType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EventRest {

    @PostMapping()
    public EventType createEvent(@Valid @RequestBody Event event) {
        String categotyName = "ice_hockey";
        return Category.valueOf(categotyName).findByName(event.type).orElseThrow(() -> new IllegalStateException());
    }

    //
//    @GetMapping
//    public Event sendOneEvent() {
//        Event event = new Event();
//        event.name = "bla bla";
//        //event.eventType = IceHockeyEvent.GOAL;
//        return event;
//    }

}
