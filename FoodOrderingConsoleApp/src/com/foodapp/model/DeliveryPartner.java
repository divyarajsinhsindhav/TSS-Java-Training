package com.foodapp.model;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartner {
    private int id;
    private String name;
    private String email;
    private List<Order> orders;

    public DeliveryPartner(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
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

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return String.format(
                "+----+----------------+----------------------+--------+\n" +
                        "| ID | Name           | Email                | Orders |\n" +
                        "+----+----------------+----------------------+--------+\n" +
                        "| %-2d | %-14s | %-20s | %-6d |\n" +
                        "+----+----------------+----------------------+--------+",
                id,
                name,
                email,
                orders == null ? 0 : orders.size()
        );
    }
}
