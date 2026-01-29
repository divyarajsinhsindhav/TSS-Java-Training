package com.tss.model;

public class ElectricVehicle extends AbstractVehicalClass{
    private int charging;

    public ElectricVehicle(int vehicleId, int charging) {
        super(vehicleId);
        this.charging = charging;
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Charging level: " + this.charging);
    }

    @Override
    public int getVehicleId() {
        return this.vehicalId;
    }

    public void chargeBattery() {
        this.charging = 100;
        System.out.println("Battery is fully charged");
    }
}
