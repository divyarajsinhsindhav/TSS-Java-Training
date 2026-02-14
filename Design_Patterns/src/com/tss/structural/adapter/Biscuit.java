package com.tss.structural.adapter;

public class Biscuit implements Items {

    private String name;
    private double price;

    public Biscuit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public double getItemPrice() {
        return price;
    }
}
