package com.tss.model;

public class VehicleInsurancePolicy extends InsurancePolicy {
    private boolean active;
    private static double RATE = 0.03;

    public VehicleInsurancePolicy(int policyNumber, String policyHolderName, double sumAssured, int duration, boolean active) {
        super(policyNumber, policyHolderName, sumAssured, duration);
        this.active = active;
    }

    @Override
    public double calculatePremium() {
        return sumAssured * RATE * duration;
    }

    @Override
    public void applyClaim() {
        if (active) {
            System.out.println("Claim approved. Policy is active.");
        } else {
            System.out.println("Claim denied. Policy is not active.");
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Policy Type: Vehicle Insurance");
        System.out.println("Policy Active: " + active);
    }
}
