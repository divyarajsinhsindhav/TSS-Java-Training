package com.tss.model;

public class LifeInsurancePolicy extends InsurancePolicy{
    private boolean matured;
    private static double RATE = 0.05;

    public LifeInsurancePolicy(int policyNumber, String policyHolderName, double sumAssured, int duration, boolean matured) {
        super(policyNumber, policyHolderName, sumAssured, duration);
        this.matured = matured;
    }

    @Override
    public double calculatePremium() {
        return sumAssured * RATE * duration;
    }

    @Override
    public void applyClaim() {
        if (matured) {
            System.out.println("Claim approved. Policy has matured.");
        } else {
            System.out.println("Claim denied. Policy has not matured yet.");
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Policy Type: Life Insurance");
        System.out.println("Matured: " + matured);
    }
}
