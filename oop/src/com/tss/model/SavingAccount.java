package com.tss.model;

public class SavingAccount extends Account{
    private final double offerRate;
    public SavingAccount(String name, double balance, double offerRate) {
        super(name, balance, AccountType.SAVING);
        this.offerRate = offerRate;
    }

    public double getOfferRate() {
        return this.offerRate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);

        if (amount > 50000) {
            double benefit = amount * offerRate / 100;
            balance += benefit;
            System.out.println("Offer benefit added: " + benefit);
        }
    }
}
