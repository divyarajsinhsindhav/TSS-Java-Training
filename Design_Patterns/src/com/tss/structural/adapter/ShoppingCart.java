package com.tss.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Items> cart;

    private ShoppingCart() {
        cart = new ArrayList<>();
    }

    private static class SingletonHolder {
        private static final ShoppingCart INSTANCE = new ShoppingCart();
    }

    public static ShoppingCart getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public List<Items> getCartItems() {
        return cart;
    }

    public void addItem(Items item) {
        cart.add(item);
    }

    public void removeItem(Items item) {
        cart.remove(item);
    }

    public void clear() {
        cart.clear();
    }

    public double getTotalPrice() {
        double totalPrice = cart.stream()
                .mapToDouble(item -> item.getItemPrice())
                .sum();
        return totalPrice;
    }

    public void displayCart() {
        for (Items item : cart) {
            System.out.println(item.getItemName() + "->" + item.getItemPrice());
        }
        System.out.println("Total: " + getTotalPrice());
    }
}
