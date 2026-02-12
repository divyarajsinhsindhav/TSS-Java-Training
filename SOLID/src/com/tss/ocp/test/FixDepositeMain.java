package com.tss.ocp.test;

import com.tss.ocp.model.*;

public class FixDepositeMain {
    public static void main(String[] args) {
        FixedDeposite fixedDeposite = new FixedDeposite(1, 2, 10000, new DiwaliOffer());
        SimpleInterest interestCalculate = new SimpleInterest(fixedDeposite);
        Display display = new Display(interestCalculate);
        display.show();
    }
}
