package com.tss.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        Notifier email = new Email();
        Notifier message = new Message();
        Account account = new Account("Divyarajsinh", 101, 200);

        account.addNotifier(email);
//        account.addNotifier(message);

        account.withdraw(100);
        account.deposit(500);
    }
}
