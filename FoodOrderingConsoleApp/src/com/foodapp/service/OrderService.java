package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.model.Order;
import com.foodapp.model.OrderItem;
import com.foodapp.model.PaymentMode;
import com.foodapp.repository.CartRepository;
import com.foodapp.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private DeliveryPartnerService deliveryPartnerService;
    private OrderRepository orderRepository;
    private CartRepository cartRepository;

    public OrderService(DeliveryPartnerService deliveryPartnerService, OrderRepository orderRepository, CartRepository cartRepository) {
        this.deliveryPartnerService = deliveryPartnerService;
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public Order placeOrder(Customer customer, PaymentMode mode, List<OrderItem> Cart) {
        return null;
    }

    private double calculateTotal(List<OrderItem> Cart) {
        return 0;
    }

    private double calculateFinalAmount(List<OrderItem> Cart) {
        return 0;
    }
}
