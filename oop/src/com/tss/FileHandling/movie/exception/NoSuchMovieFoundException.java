package com.tss.FileHandling.movie.exception;

public class NoSuchMovieFoundException extends RuntimeException {
    public NoSuchMovieFoundException() {
        super("No such movie found");
    }
}
