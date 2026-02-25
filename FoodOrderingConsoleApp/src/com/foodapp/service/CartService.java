package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.model.OrderItem;
import com.foodapp.repository.CartRepository;

import java.util.List;

public class CartService {

    private CartRepository cartRepository;
    private CustomerService customerService;

    public CartService(CartRepository cartRepository,  CustomerService customerService) {
        this.customerService = customerService;
        this.cartRepository = cartRepository;
    }

    public void addOrderItemToCart(Integer customerId, OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order Item cannot be null");
        }
        if (customerId == null) {
            throw new IllegalArgumentException("Customer Id cannot be null");
        }
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        cartRepository.addToCart(customerId, orderItem);
    }

    public OrderItem getOrderItemFromCart(Integer customerId, int orderItemId) {

        Customer customer = customerService.findCustomerById(customerId);

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return cartRepository.getCart(customerId)
                .stream()
                .filter(item -> item.getId() == orderItemId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Order item not found in cart"));
    }

    public void removeOrderItemFromCart(Integer customerId, OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order Item cannot be null");
        }
        if (customerId == null) {
            throw new IllegalArgumentException("Customer Id cannot be null");
        }
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        cartRepository.removeFromCart(customerId, orderItem);
    }

    public void updateOrderItemQuantity(Integer customerId, OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order Item cannot be null");
        }
        if (customerId == null) {
            throw new IllegalArgumentException("Customer Id cannot be null");
        }
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    public List<OrderItem> getCart(Integer customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return cartRepository.getCart(customerId);
    }

    public void clearCustomerCart(Integer customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        cartRepository.clearCart(customerId);
    }

}
