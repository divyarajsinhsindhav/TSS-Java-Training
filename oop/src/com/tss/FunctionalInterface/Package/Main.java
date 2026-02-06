package com.tss.FunctionalInterface.Package;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            menu();
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    creditCardPayment();
                    break;
                case 2:
                    upiPayment();
                    break;
                case 3:
                    netBankingPayment();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid userChoice! Try again.");
            }
        }
    }

    public static void menu() {
        System.out.println("1. Credit Card Payment");
        System.out.println("2. UPI Payment");
        System.out.println("3. Net Banking Payment");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void creditCardPayment() {
        Payment creditCardPayment = amount -> amount <= 100000;
        System.out.print("Enter amount: ");
        double userAmount = scanner.nextDouble();
        PaymentProcessor.processPayment(creditCardPayment, userAmount);
    }

    public static void upiPayment() {
        Payment upiPayment = amount -> amount <= 50000;
        System.out.print("Enter amount: ");
        double userAmount = scanner.nextDouble();
        PaymentProcessor.processPayment(upiPayment, userAmount);
    }

    public static void netBankingPayment() {
        Payment netBankingPayment = amount -> true;
        System.out.print("Enter amount: ");
        double userAmount = scanner.nextDouble();
        PaymentProcessor.processPayment(netBankingPayment, userAmount);
    }
}
