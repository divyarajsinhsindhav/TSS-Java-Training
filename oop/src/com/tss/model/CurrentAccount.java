package com.tss.model;

import com.tss.Exception.MinimumBalanceException;

public class CurrentAccount extends Account{
    private final static double MINIMUM_BALANCE = 500.0;
    public CurrentAccount(String name, double balance) {
        super(name, balance, AccountType.CURRENT);
        if (balance < MINIMUM_BALANCE) {
            throw new MinimumBalanceException(MINIMUM_BALANCE);
        }
    }

    public static double getMINIMUM_BALANCE() {
        return MINIMUM_BALANCE;
    }

    @Override
    public void withdraw(double amount){
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            throw new MinimumBalanceException(MINIMUM_BALANCE);
        }
    }
}
