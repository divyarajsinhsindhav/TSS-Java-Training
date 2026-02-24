package com.foodapp.service;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.repository.DeliveryPartnerRepository;

import java.util.List;
import java.util.Random;

public class DeliveryPartnerService {

    private DeliveryPartnerRepository deliveryPartnerRepository;

    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        if (deliveryPartnerRepository == null) {
            throw new NullPointerException("deliveryPartnerRepository is null");
        }

        deliveryPartnerRepository.addDeliveryPartner(deliveryPartner);
    }

    public DeliveryPartner getDeliveryPartnerById(int id) {
        for (DeliveryPartner partner : deliveryPartnerRepository.getAllDeliveryPartners()) {
            if (partner.getId() == id) {
                return partner;
            }
        }
        return null;
    }

    public DeliveryPartner getDeliveryPartner(int id) {
        if (deliveryPartnerRepository == null) {
            throw new NullPointerException("DeliveryPartnerRepository is null");
        }

        DeliveryPartner partner = getDeliveryPartnerById(id);

        if (partner == null) {
            throw new IllegalArgumentException("Delivery Partner not found with id: " + id);
        }

        return partner;
    }

    public DeliveryPartner assignDeliveryPartnerRandomly() {
        if (deliveryPartnerRepository == null) {
            throw new NullPointerException("DeliveryPartnerRepository is null");
        }

        List<DeliveryPartner> partners = deliveryPartnerRepository.getAllDeliveryPartners();

        if (partners.isEmpty()) {
            throw new IllegalStateException("No delivery partners available");
        }

        Random random = new Random();
        int index = random.nextInt(partners.size());

        DeliveryPartner assignedPartner = partners.get(index);

        return assignedPartner;
    }
}
