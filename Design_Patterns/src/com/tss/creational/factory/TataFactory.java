package com.tss.creational.factory;

public class TataFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Tata();
    }
}
