package com.foodapp.model;

import java.util.List;

public class FoodItem implements Menu {
    private int id;
    private String name;
    private double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void add(Menu item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Menu item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Menu> getMenu() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void render(String indent) {

        System.out.printf("%-4d %-28s ₹%-8.2f%n",
                id,
                name,
                price);
    }
}
