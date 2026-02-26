package com.foodapp.model;

public class DeliveryPartner {
    private int id;
    private String name;
    private String email;

    public DeliveryPartner(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format(
                "+----+----------------+----------------------+\n" +
                        "| ID | Name           | Email                |\n" +
                        "+----+----------------+----------------------+\n" +
                        "| %-2d | %-14s | %-20s |\n" +
                        "+----+----------------+----------------------+",
                id,
                name,
                email
        );
    }
}
