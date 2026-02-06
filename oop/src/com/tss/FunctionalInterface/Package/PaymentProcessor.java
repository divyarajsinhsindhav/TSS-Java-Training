package com.tss.FunctionalInterface.Package;

public class PaymentProcessor {
    public static void processPayment(Payment payment, double amount) {
        boolean result = payment.pay(amount);

        if (!result) {
            System.out.println("Payment failed");
            return;
        }
        System.out.println("Payment successful");
    }
}
