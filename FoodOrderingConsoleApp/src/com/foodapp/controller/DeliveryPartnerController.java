package com.foodapp.controller;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.repository.DeliveryPartnerRepository;
import com.foodapp.service.DeliveryPartnerService;
import com.foodapp.utils.IdGenerator;
import com.foodapp.utils.InputValidation;

import java.util.Scanner;

public class DeliveryPartnerController {

    private DeliveryPartnerService deliveryPartnerService;

    private Scanner scanner = new Scanner(System.in);

    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }

    public void getDeliveryPartnersOrder() {
        int deliveryPartnerId = InputValidation.readPositiveInt(scanner, "Enter your id: ");
        DeliveryPartner deliveryPartner = deliveryPartnerService.getDeliveryPartner(deliveryPartnerId);
        deliveryPartner.getOrders()
                .stream()
                .forEach(System.out::println);
    }

}
