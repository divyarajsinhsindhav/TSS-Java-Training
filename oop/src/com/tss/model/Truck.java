package com.tss.model;

public class Truck extends AbstractVehicalClass{
    protected int fuel;

    public Truck(int vehicleId, int fuel) {
        super(vehicleId);
        this.fuel = fuel;
    }


    @Override
    public int getVehicleId() {
        return this.vehicalId;
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Truck Fuel Status: " + this.fuel);
    }
}
