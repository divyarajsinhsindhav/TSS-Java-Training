package com.foodapp.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private int phone;

    public Customer(int id, String name, String email, int phone) {
        if (id <= 0) {
            throw new IllegalArgumentException("Customer id must be greater than 0");
        }

        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }

        if (email == null || email.length() == 0) {
            throw new IllegalArgumentException("Customer email cannot be null or empty");
        }

        if (phone <= 0) {
            throw new IllegalArgumentException("Customer phone number must be greater than 0");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format(
                "+----+----------------+----------------------+------------+\n" +
                        "| ID | Name           | Email                | Phone      |\n" +
                        "+----+----------------+----------------------+------------+\n" +
                        "| %-2d | %-14s | %-20s | %-10d |\n" +
                        "+----+----------------+----------------------+------------+",
                id, name, email, phone
        );
    }
}
