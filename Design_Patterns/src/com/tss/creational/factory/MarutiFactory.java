package com.tss.creational.factory;

public class MarutiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Maruti();
    };
}
