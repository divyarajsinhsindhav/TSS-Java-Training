package com.tss.model;

public class Course {
    private int id;
    private String name;
    private double fees;
    private double paidFees;
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

    public void setPaidFees(double paidFees) {
        this.paidFees = paidFees;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getFees() {
        return this.fees;
    }

    public int getDuration() {
        return this.duration;
    }

    public double getPaidFees() {
        return this.paidFees;
    }

    public double getPenddingFees() {
        return this.fees - this.paidFees;
    }

    public String toString() {
        return "Course Id: " + this.id +
                "\nCourse Name: " + this.name +
                "\nCourse Fees: " + this.fees +
                "\nPaid Fees: " + this.paidFees +
                "\nCourse Duration: " + this.duration;
    }
}
