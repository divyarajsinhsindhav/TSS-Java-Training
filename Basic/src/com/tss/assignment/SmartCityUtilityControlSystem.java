package com.tss.assignment;
import java.util.Scanner;

public class SmartCityUtilityControlSystem {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while(true) {
            int userChoice = mainMenu();
            switch (userChoice) {
                case 1:
                    electricityService();
                    break;
                case 2:
                    waterService();
                    break;
                case 3:
                    internetService();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter valid choice");
                    continue;
            }
        }

    }

    /*
     * Main Menu
     */
    public static int mainMenu() {
        System.out.println("\n========== Smart City Utility Control System ========== \n");

        System.out.println("Main Menu: \n1. Electricity Service \n2. Water Service \n3. Internet Service \n4. Exit \n");

        System.out.println("Enter your choice: ");
        int userChoice = scanner.nextInt();

        return userChoice;
    }

    /*
     * Electricity Service
     */
    public static void electricityService() {
        while (true) {
            System.out.println("\n---------- Electricity Service ----------");

            System.out.println("\n1. Domestic Connection \n2. Commercial Connection \n3. Industrial Connection \n4. Back");
            System.out.println("Enter your choice:");
            int user_subchoice = scanner.nextInt();

            String connection_type = "";
            double energy_charge = 0;
            double extra = 0;
            double total_bill = 0;
            double rebate = 0;
            int units_consumed = 0;
            int fixed_charge = 0;

            switch (user_subchoice) {
                case 1:
                    units_consumed = getUnitsConsumed();
                    connection_type = "Domestic Connection";
                    fixed_charge = 50;

                    calculateDomesticElectricityBill(connection_type, units_consumed, fixed_charge, energy_charge, extra, rebate, total_bill);

                    break;
                case 2:
                    units_consumed = getUnitsConsumed();
                    connection_type = "Commercial Connection";
                    fixed_charge = 150;

                    calculateCommercialElectricityBill(connection_type, units_consumed, fixed_charge, energy_charge, extra, rebate, total_bill);

                    break;
                case 3:
                    units_consumed = getUnitsConsumed();
                    connection_type = "Industrial Connection";
                    fixed_charge = 500;

                    calculateIndustrialElectricityBill(connection_type, units_consumed, fixed_charge, energy_charge, extra, rebate, total_bill);

                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nPlease enter valid choice");
                    continue;
            }

        }
    }

    private static int getUnitsConsumed() {
        System.out.println("\nEnter units consumed: ");
        int units_consumed = scanner.nextInt();
        return units_consumed;
    }

    private static void displayElectricityData(String connection_type, int units_consumed, double energy_charge, double fixed_charge, double extra, double rebate, double total_bill) {
        System.out.println("\nConnection Type: " + connection_type);
        System.out.println("Units: " + units_consumed);
        System.out.println("Energy Charge: " + energy_charge);
        System.out.println("Fixed Charge: " + fixed_charge);
        System.out.println("Extra: " + extra);
        System.out.println("Rebate: " + rebate);
        System.out.println("Total Bill: " + total_bill);
    }

    private static void calculateDomesticElectricityBill(String connection_type, int units_consumed, double fixed_charge, double energy_charge, double extra, double rebate, double total_bill) {
        if (units_consumed >= 0 && units_consumed <= 100) {
            energy_charge = units_consumed * 2;
        } else if (units_consumed >= 101 && units_consumed <= 300) {
            energy_charge = (100 * 2) + ((units_consumed - 100) * 3);
        } else if (units_consumed >= 301) {
            energy_charge = (100 * 2) + (200 * 3) + ((units_consumed - 300) * 5);
        }

        if (energy_charge > 2000) {
            extra = energy_charge * 0.10;
        }

        total_bill = energy_charge + fixed_charge + extra;
        displayElectricityData(connection_type, units_consumed, energy_charge, fixed_charge, extra, rebate, total_bill);
    }

    private static void calculateCommercialElectricityBill(String connection_type, int units_consumed, double fixed_charge, double energy_charge, double extra, double rebate, double total_bill) {
        if (units_consumed >= 0 && units_consumed <= 200) {
            energy_charge = units_consumed*5;
        } else if (units_consumed >= 201 && units_consumed <= 500) {
            energy_charge = (200 * 5) + ((units_consumed - 200) * 7);
        } else if (units_consumed >= 501) {
            energy_charge = (200 * 5) + (300 * 7) + ((units_consumed - 500) * 10);
        }

        total_bill = energy_charge + fixed_charge;
        displayElectricityData(connection_type, units_consumed, energy_charge, fixed_charge, extra, rebate, total_bill);
    }

    private static void calculateIndustrialElectricityBill(String connection_type, int units_consumed, double fixed_charge, double energy_charge, double extra, double rebate, double total_bill) {
        energy_charge = units_consumed * 12;

        if (units_consumed > 1000) {
            rebate = energy_charge * 0.15;
        }

        total_bill = (energy_charge + fixed_charge) - rebate;
        displayElectricityData(connection_type, units_consumed, energy_charge, fixed_charge, extra, rebate, total_bill);
    }

    /*
     * Water Service
     */
    public static void waterService() {
        while (true) {
            System.out.println("\n---------- Water Service ----------");

            System.out.println("\n1. Residential Connection \n2. Society Connection \n3. Factory Connection \n4. Back");
            System.out.println("\nEnter your choice:");
            int user_subchoice = scanner.nextInt();

            final double RESIDENTIAL_PER_PERSON_CHARGE = 30;
            final double SOCIETY_PER_TAP_CHARGE = 25;
            final double FACTORY_PER_MACHINE_CHARGE = 100;

            double total_bill = 0;
            String service_type = "";
            double tax = 0;

            switch (user_subchoice) {
                case 1:
                    service_type = "Residential";
                    System.out.println("Enter number of person: ");
                    int number_of_person = scanner.nextInt();
                    total_bill = number_of_person * RESIDENTIAL_PER_PERSON_CHARGE;
                    break;
                case 2:
                    service_type = "Society";
                    System.out.println("Enter number of tap: ");
                    int number_of_tap = scanner.nextInt();
                    total_bill = number_of_tap * SOCIETY_PER_TAP_CHARGE;
                    break;
                case 3:
                    service_type = "Factory";
                    System.out.println("Enter number of machine: ");
                    int number_of_machine = scanner.nextInt();
                    total_bill = number_of_machine * FACTORY_PER_MACHINE_CHARGE;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter valid choice");
                    continue;
            }

            if (total_bill > 3000) {
                tax = total_bill * 0.08;
                total_bill += tax;
            }

            displayWaterServiceData(user_subchoice, service_type, tax, RESIDENTIAL_PER_PERSON_CHARGE, SOCIETY_PER_TAP_CHARGE, FACTORY_PER_MACHINE_CHARGE, total_bill);
        }
    }

    private static void displayWaterServiceData(int user_subchoice, String service_type, double tax, double RESIDENTIAL_PER_PERSON_CHARGE, double SOCIETY_PER_TAP_CHARGE, double FACTORY_PER_MACHINE_CHARGE, double total_bill) {
        System.out.println("Service Type: " + service_type);
        System.out.println("Tax: " + tax);
        if (user_subchoice == 1) {
            System.out.println("Fixed Charge: " + RESIDENTIAL_PER_PERSON_CHARGE);
        } else if (user_subchoice == 2) {
            System.out.println("Fixed Charge: " + SOCIETY_PER_TAP_CHARGE);
        } else if (user_subchoice == 3) {
            System.out.println("Fixed Charge: " + FACTORY_PER_MACHINE_CHARGE);
        }
        System.out.println("Total Bill: " + total_bill);
    }

    /*
     * Internet Service
     */
    public static void internetService() {
        while (true) {
            System.out.println("\n---------- Internet Service ----------");

            System.out.println("\n1. Student Plan \n2. Home Plan \n3. Business Plan \n4. Back");
            System.out.println("\nEnter your choice:");
            int user_subchoice = scanner.nextInt();

            String plan_type = "";
            double bill = 0;
            int duration = 0;
            double discount = 0;

            switch (user_subchoice) {
                case 1:
                    while(true) {
                        plan_type = "Student Plan";
                        duration = getDuration();
                        if (duration == 1) {
                            bill = 299;
                            break;
                        } else if (duration == 3) {
                            bill = 799;
                            break;
                        } else if (duration == 6) {
                            bill = 1499;
                            break;
                        } else {
                            System.out.println("Enter valid duration");
                            continue;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        plan_type = "Home Plan";
                        duration = getDuration();
                        if (duration == 1) {
                            bill = 499;
                            break;
                        } else if (duration == 3) {
                            bill = 1399;
                            break;
                        } else if (duration == 6) {
                            bill = 2699;
                            break;
                        } else {
                            System.out.println("Enter valid duration");
                            continue;
                        }
                    }
                    break;
                case 3:
                    while(true) {
                        plan_type = "Business Plan";
                        duration = getDuration();
                        if (duration == 1) {
                            bill = 999;
                            break;
                        } else if (duration == 3) {
                            bill = 2799;
                            break;
                        } else if (duration == 6) {
                            bill = 5499;
                            break;
                        } else {
                            System.out.println("Enter valid duration");
                            continue;
                        }
                    }

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter valid choice");
                    continue;
            }
            if (duration == 6) {
                discount = bill*0.05;
                bill = bill - discount;
            }
            displayInternetServiceData(plan_type, duration, discount, bill);
        }
    }
    private static int getDuration() {
        System.out.println("Enter duration(1, 3, 6 months): ");
        int duration = scanner.nextInt();
        return duration;
    }
    private static void displayInternetServiceData(String plan_type, int duration, double discount, double bill) {
        System.out.println("Plan type: " + plan_type);
        System.out.println("Duration: " + duration);
        System.out.println("Discount: " + discount);
        System.out.println("Bill: " + bill);
    }

}