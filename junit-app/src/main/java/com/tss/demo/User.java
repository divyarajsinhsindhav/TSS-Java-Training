package com.tss.demo;

public class User {
    public boolean isAdult(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
        if (age > 18) {
            return true;
        }
        return false;
    }
}
