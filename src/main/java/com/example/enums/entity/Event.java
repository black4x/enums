package com.example.enums.entity;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enum eventType;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticker ticker;

    public String getEventTypeName() {
        return this.ticker.getCategory().getEventName(eventType);
    }

    // -- getters setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getEventType() {
        return eventType;
    }

    public void setEventType(Enum eventType) {
        this.eventType = eventType;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }
}