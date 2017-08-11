package com.example.enums.model;

import com.example.enums.entity.Event;
import com.example.enums.entity.Ticker;
import com.example.enums.model.types.IceHockey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {

    ObjectMapper MAPPER = new ObjectMapper();

    @Test(expected = IllegalArgumentException.class)
    public void findNotExistingCategory() {
        Category.get("error");
    }

    @Test
    public void getOneCategory() {
        assertThat(Category.get("ice_hockey")).isEqualTo(Category.ICE_HOCKEY);
    }

    @Test
    public void getEventName()
    {
        Ticker ticker = new Ticker();
        ticker.setCategory(Category.ICE_HOCKEY);
        Event event = new Event();
        event.setTicker(ticker);
        event.setEventType(IceHockey.GOAL);
        assertThat(event.getEventTypeName()).isEqualTo(IceHockey.GOAL.getName());
    }

    @Test
    public void getEventsFromCategory() {
        assertThat(Category.get("ice_hockey").findByName("goal")).isEqualTo(IceHockey.GOAL);
    }

    @Test
    public void testCategorySerializing() throws JsonProcessingException {

        Map<String, EventType[]> result = new HashMap<>();

        for (Category category : Category.values()) {
            result.put(category.getName(), category.getEventTypes());
        }

        String categoriesJson = "{soccer:[goal,info,penalty],ice_hockey:[goal,info]}";
        assertThat(MAPPER.writeValueAsString(result).replaceAll("\"", "")).isEqualTo(categoriesJson);
    }
}