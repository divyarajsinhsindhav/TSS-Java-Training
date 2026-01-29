package com.tss.test;

import com.tss.model.*;

import java.util.Scanner;

public class VehicleTest {
    private final static int MAX_NUMBER_VEHICLE = 10;
    private static Vehicle[] vehicleArray = new Vehicle[MAX_NUMBER_VEHICLE];
    private static int countOfVehcle = 0;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            int userChoice = menu();
            switch (userChoice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    startVehicle();
                    break;
                case 3:
                    stopVehicle();
                    break;
                case 4:
                    chargeBattery();
                    break;
                case 5:
                    playHornOrMusic();
                    break;
                case 6:
                    doVehicleInspection();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Choose valid option");
            }
        }
    }

    private static int menu() {
        System.out.println("""
                1. Add a Vehicle
                2. Start a Vehicle
                3. Stop a Vehicle
                4. Charge Battery (for electric vehicle)
                5. Play Horn/Music
                6. Perform vehicle inspection
                7. Exit
                """);
        System.out.println("Enter your choice: ");
        int userChoice;
        while(true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Choice must be in the number formate");
            } else {
                userChoice = scanner.nextInt();
                if (userChoice < 0 || userChoice > 7) {
                    System.out.println("Choice must be between 1 to 7");
                    System.out.println("Choose valid option: ");
                    continue;
                }
                break;
            }
        }
        return userChoice;
    }

    private static void addVehicle() {
        if (countOfVehcle == MAX_NUMBER_VEHICLE) {
            System.out.println("No more space to create the new vehicle.");
            return;
        }

        int userChoice;
        while (true) {
            System.out.println("""
                    1. Car
                    2. Bike
                    3. Truck
                    4. Electric Vehicle
                    5. Don't want to create
                    """);
            System.out.println("Which vehicle you want to create?");
            if (!scanner.hasNextInt()) {
                System.out.println("Choice must be integer");
            } else {
                userChoice = scanner.nextInt();
                if (userChoice < 0 || userChoice > 7) {
                    System.out.println("Choice must be between 1 to 7");
                    System.out.println("Choose valid option: ");
                    continue;
                }
                int vehicleId;
                int fuelAmount;
                Vehicle v = null;
                switch (userChoice) {
                    case 1:
                        System.out.println("Enter vehicle Id: ");
                        vehicleId = scanner.nextInt();
                        System.out.println("Enter fuel amount: ");
                        fuelAmount = scanner.nextInt();
                        v = getVehicleById(vehicleId);
                        if (v == null) {
                            vehicleArray[countOfVehcle] = new Car(vehicleId, fuelAmount);
                            countOfVehcle++;
                        } else {
                            System.out.println("Vehicle with " + vehicleId + " already available.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter vehicle Id: ");
                        vehicleId = scanner.nextInt();
                        System.out.println("Enter fuel amount: ");
                        fuelAmount = scanner.nextInt();
                        v = getVehicleById(vehicleId);
                        if (v == null) {
                            vehicleArray[countOfVehcle] = new Bike(vehicleId, fuelAmount);
                            countOfVehcle++;
                        } else {
                            System.out.println("Vehicle with " + vehicleId + " already available.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter vehicle Id: ");
                        vehicleId = scanner.nextInt();
                        System.out.println("Enter fuel amount: ");
                        fuelAmount = scanner.nextInt();
                        v = getVehicleById(vehicleId);
                        if (v == null) {
                            vehicleArray[countOfVehcle] = new Truck(vehicleId, fuelAmount);
                            countOfVehcle++;
                        } else {
                            System.out.println("Vehicle with " + vehicleId + " already available.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter vehicle Id: ");
                        vehicleId = scanner.nextInt();
                        System.out.println("Enter charging amount: ");
                        int chargingAmount = scanner.nextInt();
                        v = getVehicleById(vehicleId);
                        if (v == null) {
                            vehicleArray[countOfVehcle] = new ElectricVehicle(vehicleId, chargingAmount);
                            countOfVehcle++;
                        } else {
                            System.out.println("Vehicle with " + vehicleId + " already available.");
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Enter valid choice.");
                }
                break;
            }
        }
    }

    private static void startVehicle() {
        System.out.println("Enter vehicle id: ");
        int vehicleId = scanner.nextInt();
        Vehicle v = getVehicleById(vehicleId);
        if (v != null) {
            v.start();
        } else {
            System.out.println("Vehicle with " + vehicleId  + " not found");
        }
    }

    private static void stopVehicle() {
        System.out.println("Enter vehicle id: ");
        int vehicleId = scanner.nextInt();
        Vehicle v = getVehicleById(vehicleId);
        if (v != null) {
            v.stop();
        } else {
            System.out.println("Vehicle with " + vehicleId  + " not found");
        }
    }

    private static void chargeBattery() {
        System.out.println("Enter vehicle id: ");
        int vehicleId = scanner.nextInt();
        Vehicle v = getVehicleById(vehicleId);
        if (v == null) {
            System.out.println("Vehicle not found");
        } else if (v instanceof ElectricVehicle ev) {
            ev.chargeBattery();
        } else {
            System.out.println("This vehicle is not electric");
        }

    }

    private static void playHornOrMusic() {
        System.out.println("Enter vehicle id: ");
        int vehicleId = scanner.nextInt();
        Vehicle v = getVehicleById(vehicleId);
        if (v != null) {
            System.out.println("""
                                1. Horn
                                2. Music
                                """);
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                v.horn();
            } else if (userChoice == 2) {
                v.playMusic();
            } else {
                System.out.println("Enter valid choice");
            }
        } else {
            System.out.println("Vehicle with " + vehicleId  + " not found");
        }
    }

    private static void doVehicleInspection() {
        System.out.println("Enter vehicle id: ");
        int vehicleId = scanner.nextInt();
        Vehicle v = getVehicleById(vehicleId);
        if (v != null) {
            Vehicle.inspectVehicle(v);
        } else {
            System.out.println("Vehicle with " + vehicleId  + " not found");
        }
    }

    private static Vehicle getVehicleById(int vehicleId) {
        Vehicle v = null;
        for (int i = 0; i < countOfVehcle; i++) {
            if (vehicleArray[i].getVehicleId() == vehicleId) {
                v = vehicleArray[i];
                break;
            }
        }
        return v;
    }
}
