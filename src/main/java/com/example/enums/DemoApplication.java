package com.example.enums;

import com.example.enums.entity.Event;
import com.example.enums.entity.Ticker;
import com.example.enums.model.Category;
import com.example.enums.model.types.IceHockey;
import com.example.enums.repository.EventRepository;
import com.example.enums.repository.TickerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(EventRepository eventRepository,
                                      TickerRepository tickerRepository) {
        return (args) -> {
            Ticker ticker = new Ticker();
            ticker.setCategory(Category.ICE_HOCKEY);
            Ticker savedTicker = tickerRepository.save(ticker);

            Event event = new Event();
            event.setEventType(IceHockey.GOAL);
            event.setTicker(savedTicker);
            eventRepository.save(event);

            Event event2 = new Event();
            event2.setEventType(IceHockey.INFO);
            event2.setTicker(savedTicker);
            eventRepository.save(event2);
        };
    }

}
