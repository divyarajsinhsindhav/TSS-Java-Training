package com.tss.structural.adapter;

public class HatAdapter implements Items {

    private Hat hat;

    public HatAdapter(Hat hat) {
        this.hat = hat;
    }

    @Override
    public String getItemName() {
        return hat.getLongName();
    }

    @Override
    public double getItemPrice() {
        double basePrice = hat.getBasePrice();
        double tax = hat.getTax();
        double price = (basePrice * (100 + tax)) / 100;
        return price;
    }
}
