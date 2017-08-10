package com.example.enums.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {


    @Test(expected = IllegalArgumentException.class)
    public void findNotExistingCategory() {
        Category.getByName("error");
    }

    @Test
    public void getOneCategory() {
        assertThat(Category.getByName("ice_hockey")).isEqualTo(Category.ICE_HOCKEY);
    }

    @Test
    public void getEventsFromCategory() {
        System.out.println(Category.getByName("ice_hockey").findByName("goal"));
    }
}