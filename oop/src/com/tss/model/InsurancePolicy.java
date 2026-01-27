package com.tss.model;

/**
 * - Role of duration in different policies
 * -- Life Insurance
 * Claim is allowed after the duration ends (policy maturity)
 * -- Health Insurance
 * Claims can be made anytime during the duration
 * -- Vehicle Insurance
 * Claims are allowed only if the policy is active during the duration
 */

public abstract class InsurancePolicy {
    protected int policyNumber;
    protected String policyHolderName;
    protected double sumAssured;
    protected int duration;
    private static double RATE;

    public InsurancePolicy(int policyNumber, String policyHolderName, double sumAssured, int duration) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.sumAssured = sumAssured;
        this.duration = duration;
    }

    public abstract double calculatePremium();
    public abstract void applyClaim();

    public int getPolicyNumber() {
        return this.policyNumber;
    }

    public void displayDetails() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Policy Holder: " + policyHolderName);
        System.out.println("Sum Assured: " + sumAssured);
        System.out.println("Policy Duration: " + duration + " years");
    }
}
