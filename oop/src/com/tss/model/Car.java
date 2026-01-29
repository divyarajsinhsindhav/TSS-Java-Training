package com.tss.model;

public class Car extends AbstractVehicalClass {
    protected int fuel;

    public Car(int vehicleId, int fuel) {
        super(vehicleId);
        this.fuel = fuel;
    }

    @Override
    public int getVehicleId() {
        return this.vehicalId;
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Car Fuel Status: " + this.fuel);
    }
}
