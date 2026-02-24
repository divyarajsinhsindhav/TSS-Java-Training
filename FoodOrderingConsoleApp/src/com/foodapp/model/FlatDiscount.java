package com.foodapp.model;

public class FlatDiscount {
    private static double flatDiscountOn;
    private static double DISCOUNT_RATE;

    public static double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    public static void setDiscountRate(double rate) {
        DISCOUNT_RATE = rate;
    }

    public static double getFlatDiscountOn() {
        return flatDiscountOn;
    }

    public static void setFlatDiscountOn(double flatDiscountOn) {
        FlatDiscount.flatDiscountOn = flatDiscountOn;
    }
}
