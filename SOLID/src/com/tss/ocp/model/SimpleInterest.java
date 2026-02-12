package com.tss.ocp.model;

public class SimpleInterest {

    private final FixedDeposite fixedDeposite;

    public SimpleInterest(FixedDeposite fixedDeposite) {
        this.fixedDeposite = fixedDeposite;
    }

    public FixedDeposite getFixedDeposite() {
        return fixedDeposite;
    }

    public double calculate() {
        return (fixedDeposite.getFestivalOffer().getInterestRate() * fixedDeposite.getAmount() * fixedDeposite.getDuration())/100 ;
    }
}
