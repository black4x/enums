package com.example.enums.entity;

import com.example.enums.model.Category;
import com.example.enums.model.types.IceHockey;
import com.example.enums.repository.EventRepository;
import com.example.enums.repository.TickerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventTest {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    TickerRepository tickerRepository;

    Ticker ticker;

    @Before
    public void initTicker() {
        Ticker ticker = new Ticker();
        ticker.setCategory(Category.ICE_HOCKEY);
        this.ticker = tickerRepository.save(ticker);
    }

    @Test
    public void saveEvent() {
        Event event = new Event();
        event.setTicker(ticker);
        event.setEventType(IceHockey.GOAL);
        eventRepository.save(event);
    }

    @Test
    public void saveAndReadEvent() {
        Event event = new Event();
        event.setTicker(ticker);
        event.setEventType(IceHockey.GOAL);
        Event savedEvent = eventRepository.save(event);
        assertThat(eventRepository.findOne(savedEvent.getId()).getEventType()).isEqualTo(IceHockey.GOAL);
    }

}