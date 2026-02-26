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

        UserRepository userRepository = new InMemoryUserRepository();
        InMemoryCartRepository inMemoryCartRepository = new InMemoryCartRepository();
        InMemoryOrderRepository inMemoryOrderRepository = new InMemoryOrderRepository();

        CustomerService customerService = new CustomerService(userRepository);
        CartService cartService = new CartService(inMemoryCartRepository, customerService);
        MenuService menuService = new MenuService();
        DeliveryPartnerService deliveryPartnerService = new DeliveryPartnerService(userRepository, inMemoryOrderRepository);
        DiscountService discountService = new DiscountService();
        OrderService orderService = new OrderService(deliveryPartnerService, inMemoryOrderRepository, inMemoryCartRepository, discountService);

        SessionManager sessionManager = SessionManager.getSessionManager();

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
            System.out.println("1. Register as Admin");
            System.out.println("2. Register as Customer");
            System.out.println("3. Register as DeliveryPartner");
            System.out.println("4. Login");
            System.out.println("5. Exit");

            int choice = InputValidation.readIntInRange(scanner, "Enter your choice: ", 1, 5);

            try {

                switch (choice) {
                    case 1 -> registerAdmin();
                    case 2 -> registerCustomer();
                    case 3 -> registerDeliveryPartner();
                    case 4 -> login();
                    case 5 -> {
                        System.out.println("Exiting application...");
                        return;
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void registerAdmin() {

    }

    private static void registerCustomer() {

    }

    private static void registerDeliveryPartner() {

    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        String email = InputValidation.readValidEmail(scanner, "Enter your email: ");

    }


//    private static void admin() {
//        adminController.displayOptions();
//    }
//
//    private static void customer() {
//        customerController.displayOption();
//    }
//
//    private static void deliveryPartner() {
//        deliveryPartnerController.getDeliveryPartnersOrder();
//    }
}