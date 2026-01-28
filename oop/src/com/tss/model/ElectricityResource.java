package com.tss.model;

public class ElectricityResource extends Resource {
    private int unitConsumed;

    public ElectricityResource(int ID, String department, double baseRate) {
        super(ID, department, baseRate);
    }

    @Override
    protected void calculateCost() {

    }
}
