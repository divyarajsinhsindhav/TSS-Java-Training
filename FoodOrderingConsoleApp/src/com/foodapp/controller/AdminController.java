package com.foodapp.controller;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.DeliveryPartnerStatus;
import com.foodapp.model.FlatDiscount;
import com.foodapp.model.MenuCategory;
import com.foodapp.service.DeliveryPartnerService;
import com.foodapp.service.MenuService;
import com.foodapp.utils.IdGenerator;
import com.foodapp.utils.InputValidation;

import java.util.List;
import java.util.Scanner;

public class AdminController {
    private final Scanner scanner;
    private final MenuService menuService;
    private final DeliveryPartnerService deliveryPartnerService;
    private MenuController menuController;

    public AdminController(MenuService menuService,
                           DeliveryPartnerService deliveryPartnerService) {
        this.scanner = new Scanner(System.in);
        this.menuService = menuService;
        this.deliveryPartnerService = deliveryPartnerService;
        this.menuController = new MenuController(menuService);
    }

    private static final int MANAGE_MENU = 1;
    private static final int MANAGE_DISCOUNT = 2;
    private static final int MANAGE_DELIVERY_PARTNER = 3;
    private static final int BACK = 4;
    public void displayOptions() {
        while (true) {

            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Manage Menu");
            System.out.println("2. Manage Discount");
            System.out.println("3. Manage Delivery Partners");
            System.out.println("4. Back");

            int choice = InputValidation.readIntInRange(scanner,
                    "Enter your choice: ", MANAGE_MENU, BACK);

            switch (choice) {
                case MANAGE_MENU -> manageMenu();
                case MANAGE_DISCOUNT -> manageDiscount();
                case MANAGE_DELIVERY_PARTNER -> manageDeliveryPartners();
                case BACK -> {
                    System.out.println("Returning to previous menu...");
                    return;
                }
            }
        }
    }

    private static final int ADD_ITEM = 1;
    private static final int ADD_CATEGORY = 2;
    private static final int MENU_BACK = 3;
    private void manageMenu() {

        while (true) {
            System.out.println("\n--- Manage Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Add Category");
            System.out.println("3. Back");

            int choice = InputValidation.readIntInRange(scanner,
                    "Enter your choice: ", ADD_ITEM, MENU_BACK);

            switch (choice) {
                case ADD_ITEM -> addItemInMenu();
                case ADD_CATEGORY -> addMenuCategory();
                case MENU_BACK -> {
                    return;
                }
            }
        }
    }

    private static final int SET_DISCOUNT = 1;
    private static final int SET_DISCOUNT_ON = 2;
    private static final int DISCOUNT_BACK = 3;
    private void manageDiscount() {

        while (true) {
            System.out.println("\n--- Manage Discount ---");
            System.out.println("1. Set Flat Discount");
            System.out.println("2. Set Discount Minimum Amount");
            System.out.println("3. Back");

            int choice = InputValidation.readIntInRange(scanner,
                    "Enter your choice: ", SET_DISCOUNT, DISCOUNT_BACK);

            switch (choice) {
                case SET_DISCOUNT -> setFlatDiscountRate();
                case SET_DISCOUNT_ON -> setFlatDiscountOn();
                case DISCOUNT_BACK -> {
                    return;
                }
            }
        }
    }

    private static final int SET_DELIVERY_PARTNER_STATUS = 1;
    private static final int DELIVERY_BACK = 2;
    private void manageDeliveryPartners() {

        while (true) {
            System.out.println("\n--- Manage Delivery Partners ---");
            System.out.println("1. Change Delivery Partner Status");
            System.out.println("2. Back");

            int choice = InputValidation.readIntInRange(scanner,
                    "Enter your choice: ", SET_DELIVERY_PARTNER_STATUS, DELIVERY_BACK);

            switch (choice) {
                case SET_DELIVERY_PARTNER_STATUS -> setStatusOfDeliveryPartner();
                case DELIVERY_BACK -> {
                    return;
                }
            }
        }
    }

    private void addMenuCategory() {

        System.out.println("\n========== Add Menu Category ==========");

        do {
            System.out.println("\nAvailable Categories:");
            menuController.displayCategory();

            int parentCategoryId = InputValidation.readPositiveZeroInt(
                    scanner, "Enter Parent Category ID (0 for root): ");

            int categoryId = IdGenerator.getNextCategoryID();

            String categoryName;

            while(true) {
                categoryName = InputValidation.readValidName(
                        scanner, "Enter new category name: ");
                MenuCategory menuCategory = menuService.findCategoryByName(parentCategoryId, categoryName);
                if (menuCategory == null) {
                    break;
                }
                System.out.println("Category with " + categoryName + " already exists for parent category!");
            };

            try {
                menuService.addCategory(parentCategoryId, categoryId, categoryName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Category '" + categoryName + "' added successfully!");

        } while (InputValidation.doUserWantToContinue(scanner,
                "Do you want to add another category?"));

    }

    private void addItemInMenu() {

        System.out.println("\n========== Add Food Item ==========");

        do {
            System.out.println("\nAvailable Categories:");
            menuController.displayCategory();

            int categoryId = InputValidation.readPositiveZeroInt(
                    scanner, "Enter category ID to add item: ");

            int foodItemId = IdGenerator.getNextItemID();

            String itemName = InputValidation.readValidName(
                    scanner, "Enter food item name: ");

            double itemPrice = InputValidation.readPositiveDouble(
                    scanner, "Enter food item price: ");

            try {
                menuService.addFoodItem(categoryId, foodItemId, itemName, itemPrice);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Food item '" + itemName + "' added successfully!");

        } while (InputValidation.doUserWantToContinue(scanner,
                "Do you want to add another item?"));

    }

    private void setFlatDiscountRate() {
        System.out.println("\n--- Set Flat Discount ---");

        int flatDiscount = InputValidation.readPositiveInt(scanner, "Enter Flat Discount: ");

        FlatDiscount.getInstance().setDiscount(flatDiscount);
        System.out.println("Discount updated successfully!");
    }

    private void setFlatDiscountOn() {
        System.out.println("\n--- Set Flat Discount On ---");

        double flatDiscount = InputValidation.readPositiveDouble(scanner, "Enter amount: ");

        FlatDiscount.getInstance().setFlatDiscountOn(flatDiscount);
        System.out.println("Amount for discount updated successfully!");
    }

    private void setStatusOfDeliveryPartner() {
        System.out.println("\n--- Change Delivery Partner Status ---");

        List<DeliveryPartner> deliveryPartners = deliveryPartnerService.getDeliveryPartners();

        if (deliveryPartners.isEmpty()) {
            System.out.println("No delivery partners available.");
            return;
        }

        System.out.printf("\n%-20s %-20s %-20s%n", "Delivery Partner Id", "Name", "Status");
        System.out.println("------------------------------------------------------------");

        deliveryPartners.forEach((deliveryPartner) -> {
            System.out.printf("%-20d %-20s %-20s%n",
                    deliveryPartner.getId(),
                    deliveryPartner.getName(),
                    deliveryPartner.getStatus());
        });

        int id = InputValidation.readPositiveInt(scanner, "Enter Delivery Partner Id: ");

        DeliveryPartner selectedPartner = null;

        selectedPartner = deliveryPartnerService.getDeliveryPartnerById(id);

        if (selectedPartner == null) {
            System.out.println("Delivery Partner not found.");
            return;
        }

        System.out.println("Select Status:");
        System.out.println("1. ACTIVE");
        System.out.println("2. INACTIVE");

        int choice = InputValidation.readIntInRange(scanner, "Enter choice: ", 1, 2);

        DeliveryPartnerStatus status;

        switch (choice) {
            case 1:
                status = DeliveryPartnerStatus.ACTIVE;
                break;
            case 2:
                status = DeliveryPartnerStatus.INACTIVE;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        deliveryPartnerService.changeDeliveryPartnerStatus(selectedPartner, status);

        System.out.println("Delivery Partner status updated successfully.");
    }
}