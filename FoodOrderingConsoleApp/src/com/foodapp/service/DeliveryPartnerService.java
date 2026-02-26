package com.foodapp.service;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.Order;
import com.foodapp.repository.InMemoryDeliveryPartnerRepository;
import com.foodapp.repository.InMemoryOrderRepository;
import com.foodapp.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DeliveryPartnerService {

    private final UserRepository userRepository;
    private final InMemoryOrderRepository inMemoryOrderRepository;
    private final Random random;

    public DeliveryPartnerService(UserRepository userRepository,
                                  InMemoryOrderRepository inMemoryOrderRepository) {

        if (userRepository == null || inMemoryOrderRepository == null) {
            throw new IllegalArgumentException("Repositories cannot be null");
        }

        this.userRepository = userRepository;
        this.inMemoryOrderRepository = inMemoryOrderRepository;
        this.random = new Random();
    }

    public List<DeliveryPartner> getDeliveryPartners() {
        return userRepository.getDeliveryPartners();
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        if (deliveryPartner == null) {
            throw new IllegalArgumentException("DeliveryPartner cannot be null");
        }

        userRepository.addUser(deliveryPartner);
    }

    public DeliveryPartner getDeliveryPartnerById(int id) {
         DeliveryPartner deliveryPartner = userRepository.getDeliveryPartnerById(id);
        if (deliveryPartner == null) {
             throw new IllegalArgumentException("DeliveryPartner with id " + id + " not found");
        }
        return deliveryPartner;
    }

    public DeliveryPartner getDeliveryPartnerByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        return userRepository.getDeliveryPartners()
                .stream()
                .filter(partner -> email.equals(partner.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public DeliveryPartner assignDeliveryPartnerRandomly() {

        List<DeliveryPartner> partners = userRepository.getDeliveryPartners();

        if (partners.isEmpty()) {
            throw new IllegalStateException("No delivery partners available");
        }

        int index = random.nextInt(partners.size());
        return partners.get(index);
    }

    public List<Order> getOrdersByDeliveryPartner(int id) {

        DeliveryPartner partner = getDeliveryPartnerById(id);
        if (partner == null) {
            throw new IllegalArgumentException("Delivery Partner not found with id: " + id);
        }

        List<Order> orders = inMemoryOrderRepository.getAllOrders()
                .stream()
                .filter(order -> order.getDeliveryPartner() != null
                        && order.getDeliveryPartner().getId() == id)
                .collect(Collectors.toList());

        return orders.isEmpty() ? Collections.emptyList() : orders;
    }

    public List<Order> getOrdersByDeliveryPartner(String email) {

        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        DeliveryPartner partner = getDeliveryPartnerByEmail(email);
        if (partner == null) {
            throw new IllegalArgumentException("Delivery Partner not found with email: " + email);
        }

        List<Order> orders = inMemoryOrderRepository.getAllOrders()
                .stream()
                .filter(order -> order.getDeliveryPartner() != null
                        && email.equals(order.getDeliveryPartner().getEmail()))
                .collect(Collectors.toList());

        return orders.isEmpty() ? Collections.emptyList() : orders;
    }
}