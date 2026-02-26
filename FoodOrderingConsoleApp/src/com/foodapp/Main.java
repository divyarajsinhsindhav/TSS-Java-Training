package com.foodapp;

import com.foodapp.controller.AdminController;
import com.foodapp.controller.CustomerController;
import com.foodapp.controller.DeliveryPartnerController;
import com.foodapp.repository.*;
import com.foodapp.service.*;
import com.foodapp.utils.InputValidation;
import com.foodapp.utils.SessionManager;

import java.util.Scanner;

public class Main {

    private static AdminController adminController;
    private static CustomerController customerController;
    private static DeliveryPartnerController deliveryPartnerController;

    public static void main(String[] args) {

        initialize();

        start();
    }

    private static void initialize() {

        InMemoryCustomerRepository inMemoryCustomerRepository = new InMemoryCustomerRepository();
        InMemoryCartRepository inMemoryCartRepository = new InMemoryCartRepository();
        InMemoryOrderRepository inMemoryOrderRepository = new InMemoryOrderRepository();
        InMemoryDeliveryPartnerRepository inMemoryDeliveryPartnerRepository = new InMemoryDeliveryPartnerRepository();

        CustomerService customerService = new CustomerService(inMemoryCustomerRepository);
        CartService cartService = new CartService(inMemoryCartRepository, customerService);
        MenuService menuService = new MenuService();
        DeliveryPartnerService deliveryPartnerService = new DeliveryPartnerService(inMemoryDeliveryPartnerRepository, inMemoryOrderRepository);
        DiscountService discountService = new DiscountService();
        OrderService orderService = new OrderService(deliveryPartnerService, inMemoryOrderRepository, inMemoryCartRepository, discountService);

        SessionManager sessionManager = new SessionManager();

        adminController = new AdminController(menuService, deliveryPartnerService);

        customerController = new CustomerController(
                customerService,
                menuService,
                orderService,
                cartService,
                sessionManager,
                deliveryPartnerService
        );

        deliveryPartnerController = new DeliveryPartnerController(deliveryPartnerService);
    }

    private static void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== FOOD ORDERING SYSTEM =====");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Delivery Partner");
            System.out.println("4. Exit");

            int choice = InputValidation.readIntInRange(scanner,
                    "Enter your choice: ", 1, 4);

            try {

                switch (choice) {
                    case 1 -> admin();
                    case 2 -> customer();
                    case 3 -> deliveryPartner();
                    case 4 -> {
                        System.out.println("Exiting application...");
                        return;
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void admin() {
        adminController.displayOptions();
    }

    private static void customer() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n===== CUSTOMER MENU =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Back");

                int choice = InputValidation.readIntInRange(scanner,
                        "Enter your choice: ", 1, 3);

                switch (choice) {
                    case 1 -> customerController.createCustomer();
                    case 2 -> customerController.login();
                    case 3 -> {
                        System.out.println("Exiting application...");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void deliveryPartner() {
        deliveryPartnerController.getDeliveryPartnersOrder();
    }
}