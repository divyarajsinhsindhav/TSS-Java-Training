package com.evalution.model;

import java.io.Serializable;
import java.util.Comparator;

public class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        if(age < 18) {
            throw new InvalidAgeException("Invalid age");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
