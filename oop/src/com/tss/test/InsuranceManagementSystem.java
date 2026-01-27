package com.tss.test;

import com.tss.model.HealthInsurancePolicy;
import com.tss.model.InsurancePolicy;
import com.tss.model.LifeInsurancePolicy;
import com.tss.model.VehicleInsurancePolicy;

import java.util.Scanner;

public class InsuranceManagementSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static InsurancePolicy[] policies = new InsurancePolicy[5];
    private static int policiesCount = 0;

    public static void main(String[] args) {
        int userChoice;
        while(true) {
            System.out.println("\n----------------------------------------");
            System.out.println(" Insurance Policy Management System");
            System.out.println("----------------------------------------");
            System.out.println("1. Create Insurance Policy");
            System.out.println("2. Calculate Premium");
            System.out.println("3. Apply for Policy Claim");
            System.out.println("4. Display Policy Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    createPolicy();
                    break;
                case 2:
                    calculatePremium();
                    break;
                case 3:
                    applyForPolicyClaim();
                    break;
                case 4:
                    for (int i = 0; i < policiesCount; i++) {
                        System.out.println("\n--- Policy " + i + " ---");
                        policies[i].displayDetails();
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }
    }

    public static void createPolicy() {
        if (policiesCount >= policies.length) {
            System.out.println("Limit exceeded to create more policies");
            return;
        }
        System.out.println("Select Policy Type:");
        System.out.println("1. Life Insurance");
        System.out.println("2. Health Insurance");
        System.out.println("3. Vehicle Insurance");
        int type = scanner.nextInt();

        System.out.print("Enter Policy Number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Policy Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Sum Assured: ");
        double sum = scanner.nextDouble();

        System.out.print("Enter Duration: ");
        int duration = scanner.nextInt();

        if (type == 1) {
            System.out.print("Is policy matured? (true/false): ");
            boolean matured = scanner.nextBoolean();
            policies[policiesCount++] =
                    new LifeInsurancePolicy(number, name, sum, duration, matured);
        }
        else if (type == 2) {
            policies[policiesCount++] =
                    new HealthInsurancePolicy(number, name, sum, duration);
        }
        else if (type == 3) {
            System.out.print("Is policy active? (true/false): ");
            boolean active = scanner.nextBoolean();
            policies[policiesCount++] =
                    new VehicleInsurancePolicy(number, name, sum, duration, active);
        }
        else {
            System.out.println("Invalid policy type!");
        }

        System.out.println("Policy created successfully.");
    }

    public static void calculatePremium() {
        System.out.print("Enter Policy Number: ");
        int policyNumber = scanner.nextInt();

        InsurancePolicy policy = getPolicyById(policyNumber);

        if (policy != null) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Premium: " + policy.calculatePremium());
        } else {
            System.out.println("Policy not found!");
        }
    }

    public static void applyForPolicyClaim() {
        System.out.print("Enter Policy Number: ");
        int policyNumber = scanner.nextInt();

        InsurancePolicy policy = getPolicyById(policyNumber);

        if (policy != null) {
            policy.applyClaim();
        } else {
            System.out.println("Policy not found!");
        }
    }

    private static InsurancePolicy getPolicyById(int policyNumber) {
        for (int i = 0; i < policiesCount; i++) {
            if (policies[i].getPolicyNumber() == policyNumber) {
                return policies[i];
            }
        }
        return null;
    }
}
