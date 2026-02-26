package com.foodapp.service;

import com.foodapp.exception.EmptyCartException;
import com.foodapp.exception.EmptyOrderException;
import com.foodapp.model.*;
import com.foodapp.repository.InMemoryCartRepository;
import com.foodapp.repository.InMemoryOrderRepository;
import com.foodapp.utils.IdGenerator;

import java.util.List;

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

    public Order placeOrder(Customer customer, PaymentMode mode, List<OrderItem> Cart) {
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

    private double calculateTotal(List<OrderItem> Cart) {
        return 0;
    }

    private double calculateFinalAmount(List<OrderItem> Cart) {
        return 0;
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
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
}
