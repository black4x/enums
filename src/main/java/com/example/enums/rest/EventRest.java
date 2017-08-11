package com.example.enums.rest;

import com.example.enums.dto.EventDTO;
import com.example.enums.entity.Event;
import com.example.enums.model.Category;
import com.example.enums.model.EventType;
import com.example.enums.model.types.IceHockey;
import com.example.enums.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EventRest {

    @Autowired
    EventRepository eventRepository;

    @PostMapping()
    public EventDTO createEvent(@Valid @RequestBody EventDTO eventDTO) {
        // search Category from ticker
        Category category = Category.get("ice_hockey");

        Event event = new Event();
        event.setEventType(category.findByName(eventDTO.getTypeName()).getEnum());
        Event savedEvent = eventRepository.save(event);


        EventDTO answer = new EventDTO();
        answer.setId(event.getId());
        String foundTypeName = category.getEventName(savedEvent.getEventType());
        answer.setType(foundTypeName);
        return answer;
    }

    @GetMapping
    public EventDTO sendOneEvent() {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setType(IceHockey.GOAL.getName());
        return eventDTO;
    }

    @GetMapping(path = "/categories")
    public Map<String, EventType[]> getAllCategories() {
        Map<String, EventType[]> result = new HashMap<>();

        for (Category category : Category.values()) {
            result.put(category.getName(), category.getEventTypes());
        }

        return result;
    }

//    @GetMapping(path = "/events")
//    public Page<EventDTO> getAllEvent(Pageable pageable) {
//        return eventRepository.findAll(pageable).map(this::convertToDTO);
//    }


    @GetMapping(path = "/events")
    public Page<Event> getAllEvent(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setType(event.getEventTypeName());
        return eventDTO;
    }
}
