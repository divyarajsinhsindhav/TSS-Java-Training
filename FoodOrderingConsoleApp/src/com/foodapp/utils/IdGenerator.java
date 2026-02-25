package com.foodapp.utils;

import java.util.Random;

public class IdGenerator {

    private static Random random = new Random();

    private static int menuIDCounter = 1000;
    private static int categoryIDCounter = 1000;
    private static int itemIDCounter = 1000;
    private static int deliveryPartnerIDCounter = 1000;
    private static int customerIDCounter = 1000;

    // Private constructor to prevent instantiation
    private IdGenerator() { }

    // Random 3-digit ID (100–999)
    public static int getRandomID() {
        return random.nextInt(900) + 100;
    }

    public static int getNextMenuID() {
        return ++menuIDCounter;
    }

    public static int getNextCategoryID() {
        return ++categoryIDCounter;
    }

    public static int getNextItemID() {
        return ++itemIDCounter;
    }

    public static int getNextDeliveryPartnerID() {
        return ++deliveryPartnerIDCounter;
    }

    public static int getNextCustomerID() {
        return ++customerIDCounter;
    }
}
