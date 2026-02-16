package com.tss.behavioral.observer;

public class Email implements Notifier{
    @Override
    public void notify(double amount, Operation operation) {
        System.out.println("Email Notification: " + operation  + " operation of $" + amount + " was completed successfully.");
    }
}
