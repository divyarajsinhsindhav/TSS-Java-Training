package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.model.OrderItem;
import com.foodapp.repository.InMemoryCartRepository;

import java.util.List;

public class CartService {

    private InMemoryCartRepository inMemoryCartRepository;
    private CustomerService customerService;

    public CartService(InMemoryCartRepository inMemoryCartRepository, CustomerService customerService) {
        this.customerService = customerService;
        this.inMemoryCartRepository = inMemoryCartRepository;
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
        inMemoryCartRepository.addToCart(customerId, orderItem);
    }

    public OrderItem getOrderItemFromCart(Integer customerId, int orderItemId) {

        Customer customer = customerService.findCustomerById(customerId);

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return inMemoryCartRepository.getCart(customerId)
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
        inMemoryCartRepository.removeFromCart(customerId, orderItem);
    }

    public void updateOrderItemQuantity(Integer customerId, OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order Item cannot be null");
        }

        if (customerId == null) {
            throw new IllegalArgumentException("Customer Id cannot be null");
        }

        Customer customer = customerService.findCustomerById(customerId);

        OrderItem itemFromCart = inMemoryCartRepository.getCart(customerId)
                .stream()
                .filter(item -> item.getId() == orderItem.getId())
                .findFirst()
                .orElse(null);
        if (itemFromCart == null) {
            throw new IllegalArgumentException("Order item not found in cart");
        }

        itemFromCart.setQuantity(orderItem.getQuantity());
        itemFromCart.setPrice(orderItem.getFoodItem().getPrice() *  orderItem.getQuantity());

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    public List<OrderItem> getCart(Integer customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return inMemoryCartRepository.getCart(customerId);
    }

    public void clearCustomerCart(Integer customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        inMemoryCartRepository.clearCart(customerId);
    }

}
