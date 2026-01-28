package com.tss.model;

public class HealthInsurancePolicy extends InsurancePolicy {
    private static double RATE = 0.07;
    public HealthInsurancePolicy(int policyNumber, String policyHolderName, double sumAssured, int duration) {
        super(policyNumber, policyHolderName, sumAssured, duration);
    }

    @Override
    public double calculatePremium() {
        return sumAssured * RATE;
    }

    @Override
    public void applyClaim() {
        System.out.println("Claim approved. Multiple claims are allowed.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Policy Type: Health Insurance");
    }
}
