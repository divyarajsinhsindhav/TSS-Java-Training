package com.tss.model;

public class Transaction {
    private final int id;
    private final double amount;
    private final TransactionType type;
    private int receiverAccountNumber;
    private int senderAccountNumber;
    private final double balanceBeforeTransaction;
    private final double balanceAfterTransaction;
    private static int count = 1000;

    public Transaction(double amount, TransactionType type, double balanceBeforeTransaction, double balanceAfterTransaction) {
        this.id = count++;
        this.amount = amount;
        this.type = type;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public Transaction(double amount, TransactionType type, int senderAccountNumber, int receiverAccountNumber, double balanceBeforeTransaction, double balanceAfterTransaction) {
        this(amount, type, balanceBeforeTransaction, balanceAfterTransaction);
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public int getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public int getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public double getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                ", receiverAccountNumber=" + receiverAccountNumber +
                ", balanceBeforeTransaction=" + balanceBeforeTransaction +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}

