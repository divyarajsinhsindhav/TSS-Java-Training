package com.foodapp.seeder;
import com.foodapp.service.MenuService;

public class MenuSeeder {

    private MenuSeeder() {
    }

    public static void seed(MenuService menuService) {

        // Root Categories
        menuService.addCategory(0, 1, "Gujarati Thali");
        menuService.addCategory(0, 2, "Gujarati Snacks");
        menuService.addCategory(0, 3, "Street Food");
        menuService.addCategory(0, 4, "Beverages");
        menuService.addCategory(0, 5, "Sweets");

        // Gujarati Thali Items
        menuService.addFoodItem(1, 1, "Kathiyawadi Thali", 220);
        menuService.addFoodItem(1, 2, "Gujarati Thali", 200);
        menuService.addFoodItem(1, 3, "Mini Gujarati Thali", 150);

        // Gujarati Snacks
        menuService.addFoodItem(2, 4, "Khaman Dhokla", 60);
        menuService.addFoodItem(2, 5, "Khandvi", 70);
        menuService.addFoodItem(2, 6, "Patra", 80);
        menuService.addFoodItem(2, 7, "Fafda", 90);
        menuService.addFoodItem(2, 8, "Thepla", 50);

        // Street Food
        menuService.addFoodItem(3, 9, "Pav Bhaji", 120);
        menuService.addFoodItem(3, 10, "Dabeli", 40);
        menuService.addFoodItem(3, 11, "Sev Usal", 90);
        menuService.addFoodItem(3, 12, "Vadapav", 35);
        menuService.addFoodItem(3, 13, "Sev Khamani", 80);

        // Beverages
        menuService.addFoodItem(4, 14, "Masala Chaas", 30);
        menuService.addFoodItem(4, 15, "Sweet Lassi", 60);
        menuService.addFoodItem(4, 16, "Mango Lassi", 80);
        menuService.addFoodItem(4, 17, "Cold Coffee", 90);

        // Sweets
        menuService.addFoodItem(5, 18, "Basundi", 120);
        menuService.addFoodItem(5, 19, "Shrikhand", 100);
        menuService.addFoodItem(5, 20, "Mohanthal", 110);
        menuService.addFoodItem(5, 21, "Jalebi", 80);
    }
}