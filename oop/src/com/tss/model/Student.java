package com.tss.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private double feesPaid;
    private double totalFees;

    public Student() {}

    public boolean setId(int id) {
        if (id <= 0) return false;
        this.id = id;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getPenddingFees() {
        return this.totalFees - this.feesPaid;
    }

    public boolean payFees(double amount) {
        if (amount > this.getPenddingFees()) {
            System.out.println("Amount is greater than pending fees.");
            return false;
        } else if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }
        this.feesPaid = this.feesPaid + amount;
        return true;
    }

    @Override
    public String toString() {
        return "Student ID: " + this.id + "\nStudent name: " + this.name + "\nStudent Course: " + this.course + "\nFees Paid: " + this.feesPaid + "\nTotal Fees: " + this.totalFees;
    }
}
