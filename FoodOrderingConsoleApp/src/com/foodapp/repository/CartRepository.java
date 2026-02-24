package com.foodapp.repository;

import com.foodapp.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private List<OrderItem> cart = new ArrayList<>();

    public void addToCart(OrderItem orderItem) {
        if (cart == null) {
            throw new NullPointerException("Cart is null");
        }
        cart.add(orderItem);
    }

    public void removeFromCart(OrderItem orderItem) {
        if (cart == null) {
            throw new NullPointerException("Cart is null");
        }
        cart.remove(orderItem);
    }

    public void clearCart() {
        cart = new ArrayList<>();
    }

    public List<OrderItem> getCart() {
        return new ArrayList<>(cart);
    }

}
