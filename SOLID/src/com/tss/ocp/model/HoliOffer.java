package com.tss.ocp.model;

public class HoliOffer implements FestivalOffer{

    private static final double OFFER_RATE = 15;

    @Override
    public double getInterestRate() {
        return OFFER_RATE;
    }
}
