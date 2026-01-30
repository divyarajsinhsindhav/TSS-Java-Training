package com.tss.Exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(double number) {
        super("Negative number not allowed. You entered " + number);
    }
}
