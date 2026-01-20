package com.tss.model;

public class Course {
    private int id;
    private String name;
    private double fees;
    private int duration;

    public Course() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFees() {
        return fees;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "Course Id: " + this.id +
                "\nCourse Name: " + this.name +
                "\nCourse Fees: " + this.fees +
                "\nCourse Duration: " + this.duration;
    }
}
