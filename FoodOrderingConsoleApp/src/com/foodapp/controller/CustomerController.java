package com.foodapp.controller;

import com.foodapp.exception.EmptyCartException;
import com.foodapp.model.*;
import com.foodapp.service.*;
import com.foodapp.utils.IdGenerator;
import com.foodapp.utils.InputValidation;
import com.foodapp.utils.SessionManager;

import java.util.List;
import java.util.Scanner;

public class CustomerController {

    private static final int ADD_ITEM = 1;
    private static final int SHOW_CART = 2;
    private static final int REMOVE_ITEM = 3;
    private static final int UPDATE_CART = 4;
    private static final int PLACE_ORDER = 5;
    private static final int VIEW_ORDERS = 6;
    private static final int LOGOUT = 7;
    private static final int BACK = 8;

    private CustomerService customerService;
    private MenuService menuService;
    private OrderService orderService;
    private CartService cartService;
    private SessionManager sessionManager;
    private DeliveryPartnerService deliveryPartnerService;

    private Scanner scanner = new Scanner(System.in);

    public CustomerController(CustomerService customerService,
                              MenuService menuService,
                              OrderService orderService,
                              CartService cartService,
                              SessionManager sessionManager,
                              DeliveryPartnerService deliveryPartnerService) {

        this.customerService = customerService;
        this.menuService = menuService;
        this.orderService = orderService;
        this.cartService = cartService;
        this.sessionManager = sessionManager;
        this.deliveryPartnerService = deliveryPartnerService;
    }

    public void createCustomer() {

        int id = IdGenerator.getNextCustomerID();
        String name = InputValidation.readValidName(scanner, "Enter Customer Name: ");
        String email = InputValidation.readValidEmail(scanner, "Enter Email: ");
        String phone = InputValidation.readValidPhone(scanner, "Enter Phone: ");

        Customer customer = new Customer(id, name, email, phone);

        customerService.createCustomer(customer);

        System.out.println("Customer created successfully.");
    }

    public void login() {

        String email = InputValidation.readValidEmail(scanner, "Enter Customer Email Id: ");
        Customer customer = customerService.findCustomerByEmail(email);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        sessionManager.login(customer);

        System.out.println("Login successful. Welcome " + customer.getName());

        displayOption();
    }

    public void logout() {

        sessionManager.logout();

        System.out.println("Logged out successfully.");
    }

    private void displayOption() {

        while (sessionManager.isLoggedIn()) {

            printOptionMenu();

            int choice = InputValidation.readIntInRange(
                    scanner,
                    "Enter your choice: ",
                    ADD_ITEM,
                    BACK
            );

            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {

        switch (choice) {

            case ADD_ITEM -> addItemToCart();

            case SHOW_CART -> displayCart();

            case REMOVE_ITEM -> removeItemFromCart();

            case UPDATE_CART -> updateCart();

            case PLACE_ORDER -> placeOrder();

            case VIEW_ORDERS -> getAllOrders();

            case LOGOUT -> logout();

            case BACK -> {
                return;
            }

            default -> System.out.println("Invalid choice.");
        }
    }

    private void printOptionMenu() {

        System.out.println("\n===== CUSTOMER MENU =====");
        System.out.println("1. Add Item To Cart");
        System.out.println("2. Show Cart Items");
        System.out.println("3. Remove Item From Cart");
        System.out.println("4. Update Cart");
        System.out.println("5. Place Order");
        System.out.println("6. View Orders");
        System.out.println("7. Logout");
        System.out.println("8. Back");
    }

    public void addItemToCart() {

        Customer customer = sessionManager.getCurrentCustomer();

        menuService.displayMenu();

        int foodId = InputValidation.readPositiveInt(scanner, "Enter Food Item ID: ");

        int quantity = InputValidation.readPositiveInt(scanner, "Enter Quantity: ");

        FoodItem foodItem = menuService.findFoodItem(foodId);

        if (foodItem == null) {
            System.out.println("Food item not found.");
            return;
        }

        int id = IdGenerator.getNextOrderItemID();

        double price = foodItem.getPrice() *  quantity;

        OrderItem orderItem = new OrderItem(id, foodItem, quantity, price);

        cartService.addOrderItemToCart(customer.getId(), orderItem);

        System.out.println("Item added to cart.");
    }

    public void removeItemFromCart() {

        Customer customer = sessionManager.getCurrentCustomer();
        displayCart();
        int orderItemId = InputValidation.readPositiveInt(scanner, "Enter Order Item ID: ");

        OrderItem orderItem = cartService.getOrderItemFromCart(customer.getId(), orderItemId);

        if (orderItem == null) {
            System.out.println("Food item not found.");
            return;
        }

        cartService.removeOrderItemFromCart(customer.getId(), orderItem);

        System.out.println("Item removed from cart.");
    }

    public void updateCart() {

        Customer customer = sessionManager.getCurrentCustomer();
        displayCart();
        int foodId = InputValidation.readPositiveInt(scanner, "Enter Food Item ID: ");

        int quantity = InputValidation.readPositiveInt(scanner, "Enter New Quantity: ");

        FoodItem foodItem = menuService.findFoodItem(foodId);

        if (foodItem == null) {
            System.out.println("Food item not found.");
            return;
        }

        OrderItem orderItem = cartService.getOrderItemFromCart(customer.getId(), foodItem.getId());

        orderItem.setQuantity(quantity);

        cartService.updateOrderItemQuantity(customer.getId(), orderItem);

        System.out.println("Cart updated successfully.");
    }

    public void getAllOrders() {

        Customer customer = sessionManager.getCurrentCustomer();

        System.out.printf("%-10s %-15s %-15s %-20s%n",
                "Order ID", "Total", "Payment", "Delivery Partner");

        System.out.println("----------------------------------------------------");

        orderService.getOrdersByCustomer(customer)
                .forEach(order ->
                        System.out.printf("%-10d %-15.2f %-15s %-20s%n",
                                order.getId(),
                                order.getFinalAmount(),
                                order.getPaymentMode(),
                                order.getDeliveryPartner().getName()
                        )
                );
    }

    private void displayCart() {

        Customer customer = sessionManager.getCurrentCustomer();
        List<OrderItem> cart = cartService.getCart(customer.getId());

        if (cart == null || cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty.");
        }

        System.out.printf("%-12s %-20s %-10s %-15s %-15s%n",
                "Item ID", "Item Name", "Quantity", "Unit Price", "Total Price");

        System.out.println("---------------------------------------------------------------------");

        cart.forEach(orderItem ->
                System.out.printf("%-12d %-20s %-10d %-15.2f %-15.2f%n",
                        orderItem.getId(),
                        orderItem.getFoodItem().getName(),
                        orderItem.getQuantity(),
                        orderItem.getFoodItem().getPrice(),
                        orderItem.getPrice()
                )
        );
    }

    public void placeOrder() {

        Customer customer = sessionManager.getCurrentCustomer();

        List<OrderItem> cart = cartService.getCart(customer.getId());

        if (cart == null || cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        PaymentMode mode = handlePayment();

        Order order;
        try {
            order = orderService.placeOrder(customer, mode, cart);
        } catch (EmptyCartException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Order placed successfully!");

        System.out.println("Assigning delivery partner.....");

        orderService.assignDeliveryPartner(order);

        System.out.println("Your delivery partner has been assigned.");

        System.out.println("Your delivery partner is " + order.getDeliveryPartner());

        InvoicePrinter.printInvoice(order);

        cartService.clearCustomerCart(customer.getId());
    }


    private PaymentMode handlePayment() {

        System.out.println("\nSelect Payment Mode");
        System.out.println("1. UPI");
        System.out.println("2. CASH");

        int choice = InputValidation.readIntInRange(scanner,
                "Enter payment option: ", 1, 2);

        return switch (choice) {
            case 1 -> PaymentMode.UPI;
            case 2 -> PaymentMode.CASH;
            default -> throw new IllegalArgumentException("Invalid payment option");
        };
    }
}