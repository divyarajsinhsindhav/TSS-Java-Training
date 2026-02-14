package com.tss.structural.assignment;

public abstract class HatDecorator implements IHat {
    protected IHat hat;
    public HatDecorator(IHat hat) {
        this.hat = hat;
    }

    @Override
    public String getDescription() {
        return hat.getDescription();
    }

    @Override
    public String getItemName() {
        return hat.getItemName();
    }

    @Override
    public String getItemColor() {
        return hat.getItemColor();
    }
}
