package com.tss.srp.model;

public class Invoice {
    private int id;
    private String description;
    private double amount;
    private double taxPercentage;

    public Invoice(int id, String description, double amount, double taxPercentage) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.taxPercentage = taxPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
