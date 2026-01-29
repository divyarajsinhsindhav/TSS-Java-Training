package com.tss.model;

public abstract class AbstractVehicalClass implements Vehicle{
    boolean isRunning = false;
    protected int vehicalId;

    public AbstractVehicalClass(int vehicalId) {
        this.vehicalId = vehicalId;
    }

    public void start() {
        if (isRunning) {
           System.out.println("Vehicle is already running");
        } else {
            this.isRunning = true;
            System.out.println("Vehicle is started");
        }
    }

    public void stop() {
        if (isRunning) {
            this.isRunning = false;
            System.out.println("Vehicle is stopped");
        } else {
            System.out.println("Vehicle is already stopped");
        }
    }


    public abstract int getVehicleId();

    public abstract void getFuelStatus();


}
