package com.tss.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private int accountNumber;
    private double balance;
    private List<Notifier> notifier;

    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.notifier = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Notifier> getNotifier() {
        return notifier;
    }

    public void setNotifier(List<Notifier> notifier) {
        this.notifier = notifier;
    }

    public void addNotifier(Notifier notifier) {
        this.notifier.add(notifier);
    }

    private void notifyObservers(double amount, Operation operation) {
        for (Notifier notifier : notifier) {
            notifier.notify(amount, operation);
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Amount is negative");
            return;
        }
        if (amount > balance) {
            System.out.println("Amount is greater than balance");
            return;
        }
        balance -= amount;
        notifyObservers(amount, Operation.WITHDRAW);
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Amount is negative");
            return;
        }
        balance += amount;
        notifyObservers(amount, Operation.DEPOSIT);
    }
}
