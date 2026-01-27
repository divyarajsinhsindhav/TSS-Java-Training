package com.tss.model;

public class Account {
    private static int accountCounter = 1;
    protected int id;
    protected int accountNumber;
    protected String name;
    protected double balance;

    public Account(String name, double balance) {
        this.id = accountCounter;
        this.accountNumber = accountCounter+1000;
        this.name = name;
        this.balance = balance;
        accountCounter++;
    }

    public int getId() {
        return id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
