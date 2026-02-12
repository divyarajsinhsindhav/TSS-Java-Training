package com.tss.creational.abstractFactory;

public class CarMain {
    public static void main(String[] args) {
        CarFactory carFactory = new JapanPaganiFactory();
        Car car = carFactory.createCar();
        car.start();
    }
}
