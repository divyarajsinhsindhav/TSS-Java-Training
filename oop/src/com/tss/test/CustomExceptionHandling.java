package com.tss.test;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String m) {
        super(m);
    }
}

public class CustomExceptionHandling {
    public static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age");
        }
    }

    public static void main(String[] args) {
        try {
            validate(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
