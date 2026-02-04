package com.tss.library.Exception;

public class AlreadyBorrowedBookException extends RuntimeException {
    public AlreadyBorrowedBookException() {
        super("Book is already borrowed");
    }
}
