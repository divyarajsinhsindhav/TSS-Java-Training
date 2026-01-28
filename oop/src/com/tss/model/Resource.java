package com.tss.model;

public abstract class Resource {
    private int ID;
    private String department;
    private double baseRate;
    private double usage;
    private double calculatedCost;

    public Resource(int ID, String department, double baseRate) {
        this.ID = ID;
        this.department = department;
        this.baseRate = baseRate;
    }

    public int getID() {
        return this.ID;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getBaseRate() {
        return this.baseRate;
    }

    public double getUsage() {
        return this.usage;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }

    public final void enterUsage() {
        calculateCost();
    }

    public final void generateBill() {

        printUsageDetails();
        printPricingDetails();
    }

    protected abstract void calculateCost();
    protected abstract void printUsageDetails();
    protected abstract void printPricingDetails();

}
