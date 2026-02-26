package com.foodapp.controller;

import com.foodapp.model.DeliveryPartner;
import com.foodapp.model.FlatDiscount;
import com.foodapp.service.DeliveryPartnerService;
import com.foodapp.service.MenuService;
import com.foodapp.utils.IdGenerator;
import com.foodapp.utils.InputValidation;

import java.util.Scanner;

public class AdminController {

    private static final int ADD_ITEM = 1;
    private static final int ADD_CATEGORY = 2;
    private static final int SET_DISCOUNT = 3;
    private static final int SET_DISCOUNT_ON = 4;
    private static final int ADD_DELIVERY_AGENT = 5;
    private static final int BACK = 6;

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

    public void displayOptions() {
        try {
            while (true) {
                printMenu();

                int choice = InputValidation.readIntInRange(scanner,
                        "Enter your choice: ", ADD_ITEM, BACK);

                if (choice == BACK) {
                    System.out.println("Returning to previous menu...");
                    return;
                }

                handleChoice(choice);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printMenu() {
        System.out.println("\n===== Admin Menu =====");
        System.out.println(ADD_ITEM + ". Add item in menu");
        System.out.println(ADD_CATEGORY + ". Add new menu category");
        System.out.println(SET_DISCOUNT + ". Set Flat Discount");
        System.out.println(SET_DISCOUNT_ON + ". Set valid amount for discount");
        System.out.println(ADD_DELIVERY_AGENT + ". Add delivery agent");
        System.out.println(BACK + ". Back");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case ADD_ITEM -> addItemInMenu();
            case ADD_CATEGORY -> addMenuCategory();
            case SET_DISCOUNT -> setFlatDiscountRate();
            case SET_DISCOUNT_ON -> setFlatDiscountOn();
            case ADD_DELIVERY_AGENT -> addDeliveryAgent();
            case BACK -> System.out.println("Returning to previous menu...");
            default -> System.out.println("Invalid choice");
        }
    }

    private void addMenuCategory() {
        System.out.println("\n--- Add Menu Category ---");
        menuController.displayCategory();
        int parentCategoryId = InputValidation.readPositiveZeroInt(scanner, "Enter parent category Id: ");

        int categoryId = IdGenerator.getNextCategoryID();
        String categoryName = InputValidation.readValidName(scanner, "Enter category name: ");

        menuService.addCategory(parentCategoryId, categoryId, categoryName);
        System.out.println("Category added successfully!");
    }

    private void addItemInMenu() {
        System.out.println("\n--- Add Item In Menu ---");

        menuController.displayCategory();
        int categoryId = InputValidation.readPositiveZeroInt(scanner, "Enter category id: ");

        int foodItemId = IdGenerator.getNextItemID();
        String itemName = InputValidation.readValidName(scanner, "Enter item name: ");

        double itemPrice = InputValidation.readPositiveDouble(scanner, "Enter item price: ");

        menuService.addFoodItem(categoryId, foodItemId, itemName, itemPrice);
        System.out.println("Food item added successfully!");
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

    private void addDeliveryAgent() {
        System.out.println("\n--- Add Delivery Agent ---");

        int deliveryAgentId = IdGenerator.getNextDeliveryPartnerID();

        String name = InputValidation.readValidName(scanner, "Enter delivery agent name: ");

        String email = InputValidation.readValidEmail(scanner, "Enter delivery agent email: ");

        DeliveryPartner deliveryPartner = new DeliveryPartner(deliveryAgentId, name, email);

        deliveryPartnerService.addDeliveryPartner(deliveryPartner);

        System.out.println("Delivery agent added successfully!");
    }
}