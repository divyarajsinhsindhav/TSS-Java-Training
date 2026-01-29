package com.tss.model;

public interface Vehicle {
    void start();
    void stop();
    void getFuelStatus();

    default void horn() {
        System.out.println("Horn");
    }

    default void playMusic() {
        System.out.println("Music");
    }

    static void inspectVehicle(Vehicle v) {
        System.out.println("Inspecting vehicle.....");
        System.out.println("Vehicle Id: " + v.getVehicleId());
        v.getFuelStatus();
    }

    int getVehicleId();
}
