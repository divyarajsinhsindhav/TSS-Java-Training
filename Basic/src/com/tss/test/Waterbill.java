package com.tss.test;

import java.util.Scanner;

public class Waterbill {
    public static void main(String[] args) {
        int meter_charge = 75;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int input = scanner.nextInt();

        int total_water_bill = 0;
        int charges = 0;
        if(input <= 100) {
            charges = input * 5;
        } else {
            if (input <= 250) {
                charges = input * 10;

            } else {
                charges = input * 20;
            }
        }

        total_water_bill = charges + meter_charge;
        System.out.println(total_water_bill);
    }
}
