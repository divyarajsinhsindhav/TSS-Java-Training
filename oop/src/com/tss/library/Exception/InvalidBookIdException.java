package com.tss.library.Exception;

public class InvalidBookIdException extends RuntimeException {
    public InvalidBookIdException() {
        super("Your given book id is invalid");
    }
}
