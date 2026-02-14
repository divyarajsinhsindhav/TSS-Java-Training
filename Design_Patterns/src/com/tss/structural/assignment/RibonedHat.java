package com.tss.structural.assignment;

public class RibonedHat extends HatDecorator{
    public RibonedHat(IHat hat) {
        super(hat);
    }

    @Override
    public String getDescription() {
        return "Riboned " + hat.getDescription() ;
    }

    @Override
    public String getItemName() {
        return "Riboned " + hat.getItemName();
    }

    @Override
    public String getItemColor() {
        return hat.getItemColor();
    }
}
