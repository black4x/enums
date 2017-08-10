package com.example.enums.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {


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
        System.out.println(Category.get("ice_hockey").findByName("goal"));
    }
}