package com.evalution.model;

public class ParkingSlot {
    protected int slotNumber;
    protected SlotStatus status;
    protected Vehicle vehicle = null;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.status = SlotStatus.FREE;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public SlotStatus getStatus() {
        return this.status;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (this.vehicle == null) {
            this.status = SlotStatus.OCCUPIED;
            this.vehicle = vehicle;
        } else {
            System.out.println("Already parked");
        }
    }

    public void removeVehicle() {
        if (this.vehicle != null) {
            this.status = SlotStatus.FREE;
            this.vehicle = null;
        } else {
            System.out.println("There is no vehicle.");
        }
    }

    @Override
    public String toString() {
        return "Slot Number: " + this.slotNumber + "\n Status: " + this.status;
    }
}
