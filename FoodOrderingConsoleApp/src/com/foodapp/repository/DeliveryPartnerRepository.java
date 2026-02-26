package com.foodapp.repository;

import com.foodapp.model.DeliveryPartner;

import java.util.List;

public interface DeliveryPartnerRepository {

    void addDeliveryPartner(DeliveryPartner deliveryPartner);

    void removeDeliveryPartner(DeliveryPartner deliveryPartner);

    List<DeliveryPartner> getAllDeliveryPartners();
}