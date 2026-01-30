package com.tss.model;

import com.tss.Exception.AgeNotValidException;

public class Voter {
    private int id;
    private String name;
    private int age;

    public Voter(int id, String name, int age) {
        this.id = id;
        this.name = name;
        if (age > 18)
            throw new AgeNotValidException(18);
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 18)
            throw new AgeNotValidException(18);
        this.age = age;
    }
}
