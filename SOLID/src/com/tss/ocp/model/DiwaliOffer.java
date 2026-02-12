package com.tss.ocp.model;

public class DiwaliOffer implements FestivalOffer {

    private static final double OFFER_RATE = 20;

    @Override
    public double getInterestRate() {
        return OFFER_RATE;
    }
}

