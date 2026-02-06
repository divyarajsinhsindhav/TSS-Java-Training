package com.tss.FunctionalInterface.MethodReference;

public class Student {
    private String name;

    Student() {
        System.out.println("Create new Student");
    }

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
