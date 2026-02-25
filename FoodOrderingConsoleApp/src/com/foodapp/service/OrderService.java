package com.foodapp.service;

import com.foodapp.exception.EmptyCartException;
import com.foodapp.exception.EmptyOrderException;
import com.foodapp.model.*;
import com.foodapp.repository.CartRepository;
import com.foodapp.repository.OrderRepository;
import com.foodapp.utils.IdGenerator;

import java.util.List;

public class OrderService {
    private DeliveryPartnerService deliveryPartnerService;
    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private PaymentService paymentService;
    private DiscountService discountService;

    public OrderService(DeliveryPartnerService deliveryPartnerService, OrderRepository orderRepository, CartRepository cartRepository,  PaymentService paymentService, DiscountService discountService) {
        this.deliveryPartnerService = deliveryPartnerService;
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.paymentService = paymentService;
        this.discountService = discountService;
    }

    public Order placeOrder(Customer customer, PaymentMode mode, List<OrderItem> Cart) {
        if (Cart.isEmpty()) {
            throw new EmptyCartException("There is nothing to place order!");
        }

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null!");
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

        return order;
    }

    private double calculateTotal(List<OrderItem> Cart) {
        return 0;
    }

    private double calculateFinalAmount(List<OrderItem> Cart) {
        return 0;
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
         int customerId = customer.getId();

         return orderRepository.getAllOrders()
                 .stream()
                 .filter(order -> order.getCustomer().getId() == customerId)
                 .toList();
    }

    public DeliveryPartner assignDeliveryPartner(Order order) {
        DeliveryPartner deliveryPartner = deliveryPartnerService.assignDeliveryPartnerRandomly();
        order.setDeliveryPartner(deliveryPartner);
        return deliveryPartner;
    }
}
