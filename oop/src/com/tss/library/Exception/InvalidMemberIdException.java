package com.tss.library.Exception;

public class InvalidMemberIdException extends RuntimeException {
    public InvalidMemberIdException() {
        super("Your given member id is invalid");
    }
}
