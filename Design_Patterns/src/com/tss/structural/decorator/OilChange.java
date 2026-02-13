package com.tss.structural.decorator;

public class OilChange extends CarServiceDecorator {

    public OilChange(CarService carService) {
        super(carService);
    }

    @Override
    public String description() {
        return carService.description() + " OilChange";
    }

    @Override
    public int getCost() {
        return carService.getCost() + 1;
    }
}
