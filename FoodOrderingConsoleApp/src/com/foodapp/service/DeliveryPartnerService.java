package com.foodapp.service;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.Order;
import com.foodapp.repository.InMemoryDeliveryPartnerRepository;
import com.foodapp.repository.InMemoryOrderRepository;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DeliveryPartnerService {

    private final InMemoryDeliveryPartnerRepository inMemoryDeliveryPartnerRepository;
    private final InMemoryOrderRepository inMemoryOrderRepository;
    private final Random random;

    public DeliveryPartnerService(InMemoryDeliveryPartnerRepository inMemoryDeliveryPartnerRepository,
                                  InMemoryOrderRepository inMemoryOrderRepository) {

        if (inMemoryDeliveryPartnerRepository == null || inMemoryOrderRepository == null) {
            throw new IllegalArgumentException("Repositories cannot be null");
        }

        this.inMemoryDeliveryPartnerRepository = inMemoryDeliveryPartnerRepository;
        this.inMemoryOrderRepository = inMemoryOrderRepository;
        this.random = new Random();
    }

    public List<DeliveryPartner> getDeliveryPartners() {
        return inMemoryDeliveryPartnerRepository.getAllDeliveryPartners();
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        if (deliveryPartner == null) {
            throw new IllegalArgumentException("DeliveryPartner cannot be null");
        }

        inMemoryDeliveryPartnerRepository.addDeliveryPartner(deliveryPartner);
    }

    public DeliveryPartner getDeliveryPartnerById(int id) {
        return inMemoryDeliveryPartnerRepository.getAllDeliveryPartners()
                .stream()
                .filter(partner -> partner.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public DeliveryPartner getDeliveryPartnerByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        return inMemoryDeliveryPartnerRepository.getAllDeliveryPartners()
                .stream()
                .filter(partner -> email.equals(partner.getEmail()))
                .findFirst()
                .orElse(null);
    }

    // Assign Random Delivery Partner
    public DeliveryPartner assignDeliveryPartnerRandomly() {

        List<DeliveryPartner> partners = inMemoryDeliveryPartnerRepository.getAllDeliveryPartners();

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