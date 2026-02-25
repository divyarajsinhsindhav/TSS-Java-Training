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

        // Repositories
        CustomerRepository customerRepository = new CustomerRepository();
        CartRepository cartRepository = new CartRepository();
        OrderRepository orderRepository = new OrderRepository();
        DeliveryPartnerRepository deliveryPartnerRepository = new DeliveryPartnerRepository();

        // Services
        CustomerService customerService = new CustomerService(customerRepository);
        CartService cartService = new CartService(cartRepository, customerService);
        MenuService menuService = new MenuService();
        PaymentService paymentService = new PaymentService();
        DeliveryPartnerService deliveryPartnerService = new DeliveryPartnerService(deliveryPartnerRepository);
        DiscountService discountService = new DiscountService();
        OrderService orderService = new OrderService(deliveryPartnerService, orderRepository, cartRepository, paymentService, discountService);

        // Session Manager
        SessionManager sessionManager = new SessionManager();

        // Controllers
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

        System.out.println("\n===== CUSTOMER MENU =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Back");

        int choice = InputValidation.readIntInRange(scanner,
                "Enter your choice: ", 1, 3);

        switch (choice) {
            case 1 -> customerController.createCustomer();
            case 2 -> customerController.login();
            case 3 -> System.out.println("Returning...");
        }
    }

    private static void deliveryPartner() {
        deliveryPartnerController.getDeliveryPartnersOrder();
    }
}