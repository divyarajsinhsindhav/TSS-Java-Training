package com.tss.srp.model;

public class PrintInvoice {
    private final TaxCalculate taxCalculate;

    public PrintInvoice(TaxCalculate taxCalculate) {
        this.taxCalculate = taxCalculate;
    }

    public void print() {
        int id = taxCalculate.getInvoice().getId();
        String description = taxCalculate.getInvoice().getDescription();
        double amount = taxCalculate.getInvoice().getAmount();
        double taxPercentage = taxCalculate.getInvoice().getTaxPercentage();
        double calculatedTax = taxCalculate.calculateTax();
        double totalAmount = amount + calculatedTax;

        System.out.println("Id: " + id + "\n" +
                "Description: " + description + "\n" +
                "Amount: " + amount + "\n" +
                        "Tax Percentage: " + taxPercentage + "\n" +
                "Calculated Tax: " + calculatedTax + "\n" +
                "Total Amount: " + totalAmount);
    }
}
