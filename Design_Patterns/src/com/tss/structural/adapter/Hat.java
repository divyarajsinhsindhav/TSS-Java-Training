package com.tss.structural.adapter;

public class Hat {
    private String shortName;
    private String longName;
    private double basePrice;
    private double tax;

    public Hat(String shortName, String longName, double basePrice, double tax) {
        this.shortName = shortName;
        this.longName = longName;
        this.basePrice = basePrice;
        this.tax = tax;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
