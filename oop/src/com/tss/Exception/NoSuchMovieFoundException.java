package com.tss.Exception;

public class NoSuchMovieFoundException extends RuntimeException {
    public NoSuchMovieFoundException() {
        super("No such movie found");
    }
}
