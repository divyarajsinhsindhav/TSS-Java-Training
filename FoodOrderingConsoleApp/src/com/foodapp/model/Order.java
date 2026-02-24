package com.foodapp.model;

import java.util.List;

public class Order {
    private int  id;
    private Customer customer;
    private List<OrderItem> orderItems;
    private double total;
    private Discount discount;
    private PaymentMode mode;
    private DeliveryPartner deliveryPartner;
    private double finalAmount;

    public Order(int id, List<OrderItem> orderItems, Customer customer,
                 double total, Discount discount, PaymentMode mode,
                double finalAmount) {
        this.id = id;
        this.orderItems = orderItems;
        this.customer = customer;
        this.total = total;
        this.discount = discount;
        this.mode = mode;
        this.finalAmount = finalAmount;
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }

    public Discount getDiscount() {
        return discount;
    }

    public PaymentMode getPaymentMode() {
        return mode;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }
}
