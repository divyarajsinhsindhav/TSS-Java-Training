package com.evalution.model;

import java.util.Objects;

public class Vehicle {
    protected int vehicleNumber;
    protected String ownerName;

    public Vehicle(int vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public int getVehicleNumber() {
        return this.vehicleNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleNumber == vehicle.vehicleNumber && Objects.equals(ownerName, vehicle.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, ownerName);
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + this.vehicleNumber + "Owner Name: " + this.ownerName;
    }
}
