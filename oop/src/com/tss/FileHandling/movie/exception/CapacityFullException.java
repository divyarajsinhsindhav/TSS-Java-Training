package com.tss.FileHandling.movie.exception;

public class CapacityFullException extends RuntimeException {
    public CapacityFullException() {
      super("Capacity Full. You can't add more movies.");
    }
}
