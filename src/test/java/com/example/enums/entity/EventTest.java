package com.example.enums.entity;

import com.example.enums.model.types.IceHockey;
import com.example.enums.repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventTest  {

    @Autowired
    EventRepository eventRepository;

    @Test
    public void saveEvent() {
        Event event = new Event();
        event.eventType = IceHockey.GOAL;
        eventRepository.save(event);
    }

    @Test
    public void saveAndReadEvent() {
        Event event = new Event();
        event.eventType = IceHockey.GOAL;
        Event savedEvent = eventRepository.save(event);
        assertThat(eventRepository.findOne(savedEvent.id).eventType).isEqualTo(IceHockey.GOAL);
    }

}