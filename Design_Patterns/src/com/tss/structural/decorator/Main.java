package com.tss.structural.decorator;

public class Main {
    public static void main(String[] args) {
        CarService carService = new OilChange(new CarInspection());
        System.out.println(carService.description());
        System.out.println(carService.getCost());
    }
}
