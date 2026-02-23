package com.tss.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    ArithmeticOperations a = new ArithmeticOperations();

    @Test
    void additionTest() {
        assertEquals(3, a.addition(1, 2));
        assertEquals(7, a.addition(4, 3));
    }


    @Test
    void substractTest() {
        int  actual = a.substract(3, 2);
        assertEquals(1, actual);
    }

    @Test
    void multiplicationTest() {
        int actual = a.multiplication(3, 2);
        assertEquals(6, actual);
    }

    @Test
    void divisionTest() {
        double actual = a.division(3.0, 2.0);
        assertEquals(1.5, actual);
    }

    @Test
    void divideByZeroTest() {
        assertThrows(ArithmeticException.class, () -> a.division(1.0, 0.0));
    }
}