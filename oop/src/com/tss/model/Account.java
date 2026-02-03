package com.tss.model;

import com.tss.Exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    protected int accountNumber;
    protected String name;
    protected double balance;
    protected AccountType accountType;
    private List<Transaction> transactionList;

    public Account(String name, double balance, int accountNumber,AccountType accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        if (balance < 0) {
            throw new NegativeNumberException(balance);
        }
        this.balance = balance;
        this.accountType = accountType;
        this.transactionList = new ArrayList<>();
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

    public String getAccountType() {
        return accountType.toString();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            double balanceBeforeTransaction = balance;
            balance += amount;
            System.out.println("Amount deposited: " + amount);
            transactionList.add(new Transaction(amount, TransactionType.DEPOSIT, balanceBeforeTransaction, this.balance));
        } else {
            throw new NegativeNumberException(amount);
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new NegativeNumberException(amount);
        }
        if (amount > 0 && amount <= balance) {
            double balanceBeforeTransaction = balance;
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            transactionList.add(new Transaction(amount, TransactionType.WITHDRAW, balanceBeforeTransaction, this.balance));
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void withdraw(double amount, TransactionType type) {
        if (type != TransactionType.TRANSFER) {
            withdraw(amount);
            return;
        }
        if (amount < 0) {
            throw new NegativeNumberException(amount);
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void deposit(double amount, TransactionType type) {
        if (type != TransactionType.TRANSFER) {
            deposit(amount);
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            throw new NegativeNumberException(amount);
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

        this.withdraw(amount, TransactionType.TRANSFER);

        if (this.getBalance() == initialBalance) {
            System.out.println("Transfer failed due to insufficient balance");
            return;
        }

        double recieverInitialBalance = receiver.getBalance();

        receiver.deposit(amount, TransactionType.TRANSFER);
        System.out.println("Transfer successful");

        transactionList.add(new Transaction(amount, TransactionType.TRANSFER, this.getAccountNumber(),receiver.getAccountNumber(), initialBalance, this.balance));
        receiver.transactionList.add(new Transaction(amount, TransactionType.TRANSFER, this.getAccountNumber(), receiver.getAccountNumber(), recieverInitialBalance, receiver.getBalance()));
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public String toString() {
        return "accountNumber=" + accountNumber +
                "\nname='" + name + '\'' +
                "\nbalance=" + balance +
                "\naccountType=" + accountType;
    }
}
