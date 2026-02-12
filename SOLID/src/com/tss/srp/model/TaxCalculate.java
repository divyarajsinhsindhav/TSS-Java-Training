package com.tss.srp.model;

public class TaxCalculate {
    private final Invoice invoice;

    public TaxCalculate(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public double calculateTax() {
        double calculatedTax = invoice.getAmount() * (invoice.getTaxPercentage()/100);
        return calculatedTax;
    }
}
