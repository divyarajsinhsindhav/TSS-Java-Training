package com.foodapp.model;

public class DeliveryPartner extends User {

    public DeliveryPartner(int id, String name, String email, String password) {
        super(id, name, email, password, UserType.DELIVERY_PARTNER);
    }

    @Override
    public String toString() {
        return String.format(
                "+----+----------------+----------------------+\n" +
                        "| ID | Name           | Email                |\n" +
                        "+----+----------------+----------------------+\n" +
                        "| %-2d | %-14s | %-20s |\n" +
                        "+----+----------------+----------------------+",
                id, name, email
        );
    }
}