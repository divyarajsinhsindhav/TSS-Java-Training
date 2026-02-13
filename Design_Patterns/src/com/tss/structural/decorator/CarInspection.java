package com.tss.structural.decorator;

public class CarInspection  implements CarService {
    @Override
    public String description() {
        return "Car Inspection";
    }

    @Override
    public int getCost() {
        return 3;
    }
}
