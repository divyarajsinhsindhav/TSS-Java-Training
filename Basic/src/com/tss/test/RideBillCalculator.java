package com.tss.test;

import java.util.Scanner;

public class RideBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter height: ");
        int height = scanner.nextInt();
        System.out.println("Enter age");
        int total_bill = 0;
        int age = scanner.nextInt();
        if (height > 120) {
            if (age < 12) {
                total_bill += 5;
            } else if (age > 12 && age <= 18) {
                total_bill += 7;
            } else if (age > 18 && age < 45) {
                total_bill += 12;
            } else if (age >= 45 && age <= 55) {
                total_bill += 0;
            }
            System.out.println("If want photo enter 1 else 0: ");
            int photo = scanner.nextInt();
            if (photo == 1) {
                total_bill += 3;
            }
        } else {
            System.out.println("Can't ride");
        }
        System.out.println("Total bill:" + total_bill);
    }
}
