package com.tss.model;

public class Bike extends AbstractVehicalClass {
    protected int fuel;

    public Bike(int vehicleId, int fuel) {
        super(vehicleId);
        this.fuel = fuel;
    }

    @Override
    public int getVehicleId() {
        return this.vehicalId;
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Bike Fuel Status: " + this.fuel);
    }
}
