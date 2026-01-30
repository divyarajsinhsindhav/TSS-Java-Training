package com.tss.Exception;

public class AgeNotValidException extends RuntimeException {
    public AgeNotValidException(int age) {
        System.out.println("Enter valid age. Age must be greater than 18. Your entered age is " + age);
    }
}
