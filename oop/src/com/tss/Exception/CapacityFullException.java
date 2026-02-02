package com.tss.Exception;

public class CapacityFullException extends RuntimeException {
    public CapacityFullException() {
      super("Capacity Full. You can't add more movies.");
    }
}
