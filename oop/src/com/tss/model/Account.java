package com.tss.model;

public class Account {
    private static int accountCounter = 1;
    protected int id;
    protected int accountNumber;
    protected String name;
    protected double balance;
    protected AccountType accountType;

    public Account(String name, double balance, AccountType accountType) {
        this.id = accountCounter;
        this.accountNumber = accountCounter+1000;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
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

    public void transferMoney(Account receiver, double amount) {
        if (receiver == null) {
            System.out.println("Receiver account not found");
            return;
        }
        if (this == receiver) {
            System.out.println("Self transfer service is not available");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }

        double initialBalance = this.getBalance();

        this.withdraw(amount);

        if (this.getBalance() == initialBalance) {
            System.out.println("Transfer failed due to insufficient balance");
            return;
        }

        receiver.deposit(amount);
        System.out.println("Transfer successful");
    }
}
