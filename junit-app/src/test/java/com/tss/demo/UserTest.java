package com.tss.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void init() {
        user = new User();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @Test
    void isAdultTrueTest() {
        assertTrue(user.isAdult(19));
    }

    @Test
    void isAdultFalseTest() {
        assertFalse(user.isAdult(10));
    }

    @Test
    void isAdultReturnFalseWhenAgeIs18() {
        assertFalse(user.isAdult(18));
    }

    @Test
    void negativeNumberAgeInputTest() {
        assertThrows(IllegalArgumentException.class, () -> user.isAdult(-10));
    }

    @AfterEach
    void uninit() {
        user = null;
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("After All Test");
    }
}