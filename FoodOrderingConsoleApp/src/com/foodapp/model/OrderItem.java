package com.foodapp.model;

public class OrderItem {
    private int id;
    private Menu foodItem;
    private int quantity;
    private double price;

    public OrderItem(int id, Menu foodItem, int quantity,  double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }

        if (foodItem == null) {
            throw new IllegalArgumentException("foodItem must not be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }

        this.id = id;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Menu getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
