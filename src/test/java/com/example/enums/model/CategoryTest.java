package com.example.enums.model;

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
    public void getEventsFromCategory() {
        assertThat(Category.get("ice_hockey").findByName("goal")).isEqualTo(IceHockey.GOAL);
    }

    @Test
    public void testCategorySerializing() throws JsonProcessingException {

        Map<String, EventType[]> result = new HashMap<>();

        for (Category category : Category.values()) {
            result.put(category.getName(), category.getEventTypes());
        }

        System.out.println(MAPPER.writeValueAsString(result));
    }
}