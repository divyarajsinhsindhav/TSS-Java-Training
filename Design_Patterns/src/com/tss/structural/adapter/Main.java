package com.tss.structural.adapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static List<Items> inventory = new ArrayList<>();
    private static ShoppingCart cart;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedTheInventory();
        displayMenu();
    }

    public static void displayMenu() {
        while (true) {
            System.out.println("\n\n========================\n" +
                    "1. Create a Shopping Cart\n" +
                    "2. Add items in the cart\n" +
                    "3. Display Cart\n" +
                    "4. Exit\n" +
                    "========================\n");
            System.out.println("\nChoose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createShoppingCart();
                case 2 -> addItemsToCart();
                case 3 -> displayShoppingCart();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void createShoppingCart() {
        if (cart != null) {
            System.out.println("Shopping cart already exists!");
            return;
        }
        cart = cart.getInstance();
        System.out.println("Cart successfully created.");
    }

    public static void displayShoppingCart() {
        if (cart != null) {
            cart.displayCart();
            return;
        }
        System.out.println("Cart not found.");
    }

    public static void displayInventory() {
        inventory.stream()
                .forEach(item -> {
                    System.out.println("Item Name: " + item.getItemName() + "-> Price: " + item.getItemPrice());
                });
    }

    public static void seedTheInventory() {
        HatAdapter hat = new HatAdapter(new Hat("HAT1", "PUMA x Ferrari Red Hat", 25.00, 4));
        Biscuit biscuit = new Biscuit("Lotus Biscoff", 20.0);
        Chocolate chocolate = new Chocolate("Dark Chocolate", 1.00);
        inventory.add(hat);
        inventory.add(biscuit);
        inventory.add(chocolate);
    }

    public static void addItemsToCart() {
        if (cart == null) {
            System.out.println("Cart not found!");
            return;
        }
        while (true) {
            displayInventory();

            System.out.println("Enter item name to add to cart (or type 'done' to finish): ");
            scanner.hasNextLine();
            String name = scanner.nextLine().toLowerCase();

            if (name.equals("done")) {
                break;
            }

            Optional<Items> tempItem = inventory.stream()
                    .filter(item -> item.getItemName().toLowerCase().equals(name))
                    .findFirst();

            if (tempItem.isPresent()) {
                cart.addItem(tempItem.get());
                System.out.println("Item added to cart successfully!\n");
            } else {
                System.out.println("Invalid item name. Please try again.\n");
            }
        }

        System.out.println("Finished adding items to cart.");
    }

}
