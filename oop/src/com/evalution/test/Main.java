package com.evalution.test;

import com.evalution.model.ParkingLot;
import com.evalution.model.ParkingSlot;
import com.evalution.model.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.createParkingSlots();
        parkingLot.showSlots();

        Vehicle v1 = new Vehicle(101, "Divyarajsinh");
        Vehicle v2 =  new Vehicle(101, "Divyarajsinh");
        Vehicle v3 = new Vehicle(103, "Priya");

        parkingLot.park(v1);
        parkingLot.park(v1);
        parkingLot.park(v3);
//        parkingLot.park(v1);

        System.out.println(v1.equals(v2));

        Object o;

        parkingLot.showSlots();

    }
}
