package com.foodapp.repository;

import com.foodapp.model.DeliveryPartner;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartnerRepository {
    List<DeliveryPartner> deliveryPartners = new ArrayList<>();

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        if(deliveryPartner == null){
            throw new IllegalArgumentException("Delivery Partner cannot be null");
        }
        deliveryPartners.add(deliveryPartner);
    }

    public void removeDeliveryPartner(DeliveryPartner deliveryPartner) {
        if(deliveryPartner == null){
            throw new IllegalArgumentException("Delivery Partner cannot be null");
        }
    }

    public List<DeliveryPartner> getAllDeliveryPartners() {
        return new ArrayList<>(deliveryPartners);
    }
}
