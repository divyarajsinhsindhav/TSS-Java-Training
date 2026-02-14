package com.tss.structural.assignment;

import com.tss.structural.assignment.IHat;

public class GoldenHat extends HatDecorator {

    public GoldenHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getItemName() {
        return "Golden " + hat.getItemName();
    }

    @Override
    public String getItemColor() {
        return "Golden " + hat.getItemColor();
    }

    @Override
    public String getDescription() {
        return "Golden " + hat.getDescription() ;
    }
}
