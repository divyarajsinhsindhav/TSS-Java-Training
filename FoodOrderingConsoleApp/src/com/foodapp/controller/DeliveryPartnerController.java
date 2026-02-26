package com.foodapp.controller;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.Order;
import com.foodapp.model.User;
import com.foodapp.service.DeliveryPartnerService;
import com.foodapp.utils.InputValidation;
import com.foodapp.utils.SessionManager;

import java.util.Scanner;

public class DeliveryPartnerController {

    private DeliveryPartnerService deliveryPartnerService;
    private SessionManager sessionManager;

    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService, SessionManager sessionManager) {
        this.deliveryPartnerService = deliveryPartnerService;
        this.sessionManager = sessionManager;
    }

    public void getDeliveryPartnersOrder() {
        User deliveryPartner = sessionManager.getCurrentCustomer();
        deliveryPartnerService.getOrdersByDeliveryPartner(deliveryPartner.getEmail())
                .forEach(order -> {

                    System.out.println("\n+-------------------------------------------+");
                    System.out.println(" Order ID : " + order.getId());
                    System.out.println(" Customer : " + order.getCustomer().getName());
                    System.out.println(" Items    :");
                    System.out.println("---------------------------------------------");

                    order.getOrderItems().forEach(item -> {
                        System.out.printf("   %-25s ₹%-8.2f%n",
                                item.getFoodItem().getName(),
                                item.getPrice());
                    });

                    System.out.println("---------------------------------------------");
                    System.out.printf(" Final Amount : ₹%.2f%n", order.getFinalAmount());
                    System.out.println("+-------------------------------------------+");
                });
    }

}
