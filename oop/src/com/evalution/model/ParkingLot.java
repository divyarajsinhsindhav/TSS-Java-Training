package com.evalution.model;

public class ParkingLot {
    protected ParkingSlot[] slot;
    public ParkingLot(int totalSlot) {
        this.slot = new ParkingSlot[totalSlot];
    }

    public void createParkingSlots() {
        for (int i = 0; i<slot.length; i++) {
            slot[i] = new ParkingSlot(i);
        }
    }

//    public void park(int slotNumber, Vehicle v) {
//        for (int i = 0; i<slot.length; i++) {
//            if (slot[i] == null) {
//                break;
//            }
//            if (slot[i].getSlotNumber() == slotNumber) {
//                if (slot[i].getStatus() == SlotStatus.FREE) {
//                    slot[i].parkVehicle(v);
//                    System.out.println("Vehicle parked");
//                    break;
//                } else {
//                    System.out.println("Slot already occupied");
//                }
//            } else {
//                System.out.println("Not found");
//                break;
//            }
//        }
//    }

    public void park(Vehicle v) {
        for (int i = 0; i<slot.length; i++) {
            if (slot[i] == null) {
                break;
            }
            if (slot[i].getStatus() == SlotStatus.FREE) {
                slot[i].parkVehicle(v);
                System.out.println("Vehicle is parked at " + slot[i].getSlotNumber());
                break;
            }
        }
    }

    public void remove(int slotNumber) {
        for (int i = 0; i<slot.length; i++) {
            if (slot[i] == null) {
                break;
            }
            if (slot[i].getSlotNumber() == slotNumber) {
                if (slot[i].getStatus() == SlotStatus.FREE) {
                    slot[i].removeVehicle();
                    break;
                } else {
                    System.out.println("Slot is already free");
                }
            } else {
                System.out.println("Not found");
                break;
            }
        }
    }

    public void showSlots() {
        StringBuffer slots = new StringBuffer();

        for (int i = 0; i<slot.length; i++) {
            if (slot[i] == null) {
                break;
            }
            slots.append("\nSlot Number: " + slot[i].getSlotNumber() + "Slot Status: " + slot[i].getStatus());
        }
        System.out.println(slots.toString());
    }

    public ParkingSlot findSlot(int slotNumber) {
        ParkingSlot s = null;
        for (int i = 0; i<slot.length; i++) {
            if (slot[i] == null) {
                break;
            }
            if (slot[i].getSlotNumber() == slotNumber) {
                s = slot[i];
            }
        }
        return s;
    }
}
