package com.tss.creational.factory;

public class CarMain {
    public static void main(String[] args) {
        CarFactory carFactory = new TataFactory();

        Car car = carFactory.createCar();
        car.start();
    }
}
