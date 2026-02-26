package com.foodapp.controller;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.Order;
import com.foodapp.service.DeliveryPartnerService;
import com.foodapp.utils.InputValidation;

import java.util.Scanner;

public class DeliveryPartnerController {

    private DeliveryPartnerService deliveryPartnerService;

    private Scanner scanner = new Scanner(System.in);

    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }

    public void getDeliveryPartnersOrder() {
        String deliveryPartnerEmail = InputValidation.readValidEmail(scanner, "Enter your email: ");
        deliveryPartnerService.getOrdersByDeliveryPartner(deliveryPartnerEmail)
                .stream()
                .forEach(order -> {
                    System.out.println(order);
                });

    }

    public void assignDeliveryPartner(Order order) {
        DeliveryPartner deliveryPartner = deliveryPartnerService.assignDeliveryPartnerRandomly();
        if (deliveryPartner == null) {
            throw new NullPointerException("No delivery partner found");
        }
        order.setDeliveryPartner(deliveryPartner);
    }

}
