package com.tss.structural.decorator;

public class WheelAlign extends CarServiceDecorator {

    public WheelAlign(CarService carService) {
        super(carService);
    }

    @Override
    public String description() {
        return carService.description() + " Wheel Align";
    }

    @Override
    public int getCost() {
        return carService.getCost() + 4;
    }

}
