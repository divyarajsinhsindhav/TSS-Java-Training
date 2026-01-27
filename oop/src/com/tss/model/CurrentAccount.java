package com.tss.model;

public class CurrentAccount extends Account{
    private final static double MINIMUM_BALANCE = 500.0;
    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    public static double getMINIMUM_BALANCE() {
        return MINIMUM_BALANCE;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Minimum balance " + MINIMUM_BALANCE + " must need to be maintain");
        }
    }
}
