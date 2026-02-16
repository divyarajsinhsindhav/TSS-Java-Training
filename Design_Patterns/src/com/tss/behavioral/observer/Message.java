package com.tss.behavioral.observer;

public class Message implements Notifier {
    @Override
    public void notify(double amount,  Operation operation) {
        System.out.println("Message Notification: " + operation  + " operation of $" + amount + " was completed successfully.");
    }
}
