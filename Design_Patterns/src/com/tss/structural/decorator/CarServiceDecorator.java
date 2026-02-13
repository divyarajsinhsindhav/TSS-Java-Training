package com.tss.structural.decorator;

public abstract class CarServiceDecorator implements CarService {

    protected CarService carService;

    public CarServiceDecorator(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String description() {
        return carService.description();
    }
    @Override
    public int getCost() {
        return carService.getCost();
    }
}
