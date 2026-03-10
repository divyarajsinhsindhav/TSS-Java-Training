package com.foodapp.service;

import com.foodapp.exception.EmptyCartException;
import com.foodapp.exception.EmptyOrderException;
import com.foodapp.model.*;
import com.foodapp.repository.InMemoryCartRepository;
import com.foodapp.repository.InMemoryOrderRepository;
import com.foodapp.utils.IdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private DeliveryPartnerService deliveryPartnerService;
    private InMemoryOrderRepository inMemoryOrderRepository;
    private InMemoryCartRepository inMemoryCartRepository;
    private DiscountService discountService;

    public OrderService(DeliveryPartnerService deliveryPartnerService, InMemoryOrderRepository inMemoryOrderRepository, InMemoryCartRepository inMemoryCartRepository, DiscountService discountService) {
        this.deliveryPartnerService = deliveryPartnerService;
        this.inMemoryOrderRepository = inMemoryOrderRepository;
        this.inMemoryCartRepository = inMemoryCartRepository;
        this.discountService = discountService;
    }

    public List<Order> getOrders() {
        return inMemoryOrderRepository.getAllOrders();
    }

    public Order placeOrder(User customer, PaymentMode mode, List<OrderItem> Cart) {
        if (Cart.isEmpty()) {
            throw new EmptyCartException("There is nothing to place order!");
        }

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null!");
        }

        if (deliveryPartnerService.getDeliveryPartners().isEmpty()) {
            throw new IllegalArgumentException("There is no delivery partner available, so for now you can't place order!");
        }

        int id = IdGenerator.getNextOrderID();

        double total = Cart.stream().mapToDouble(OrderItem::getPrice).sum();

        double discountRate = discountService.applyFlatDiscount(total);

        double finalAmount = total - (total * discountRate / 100);

        Payment payment = PaymentFactory.getPaymentMethod(mode);

        if (payment == null) {
            throw new IllegalArgumentException("Something went wrong while paying!");
        }

        payment.pay(finalAmount);

        Order order = new Order(id, Cart, customer, total, discountRate, mode,  finalAmount);

        if (order == null) {
            throw new EmptyOrderException("Something went wrong while placing order!");
        }

        inMemoryOrderRepository.addOrder(order);

        return order;
    }

    public void outForDelivery(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order is null");
        }

        order.setOrderStatus(OrderStatus.OUT_OF_DELIVERY);
    }

    public List<Order> getOrdersByCustomer(User customer) {
         int customerId = customer.getId();

         return inMemoryOrderRepository.getAllOrders()
                 .stream()
                 .filter(order -> order.getCustomer().getId() == customerId)
                 .toList();
    }

    public DeliveryPartner assignDeliveryPartner(Order order) {
        DeliveryPartner deliveryPartner = deliveryPartnerService.assignDeliveryPartnerRandomly();
        order.setDeliveryPartner(deliveryPartner);
        return deliveryPartner;
    }

    public Map<String, Object> orderStats() {

        Map<String, Object> stats = new HashMap<>();

        List<Order> orders = inMemoryOrderRepository.getAllOrders();

        int totalOrders = orders.size();

        double totalRevenue = orders.stream()
                .mapToDouble(Order::getFinalAmount)
                .sum();

        stats.put("totalOrders", totalOrders);
        stats.put("totalRevenue", totalRevenue);

        return stats;
    }
}
