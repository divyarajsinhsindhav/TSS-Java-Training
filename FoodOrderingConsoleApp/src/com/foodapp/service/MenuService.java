package com.foodapp.service;

import com.foodapp.model.*;

public class MenuService {

    private final Menu root;

    public MenuService() {
        this.root = new MenuCategory(0, "FOOD MENU");
    }

    public Menu getRoot() {
        return root;
    }

    public void addCategory(int parentId, int id, String categoryName) {

        MenuCategory parent = findCategoryById(root, parentId);

        if (parent == null) {
            throw new RuntimeException("Parent category not found");
        }

        parent.add(new MenuCategory(id, categoryName));
    }

    public void addFoodItem(int categoryId, int id, String name, double price) {

        MenuCategory category = findCategoryById(root, categoryId);

        if (category == null) {
            throw new RuntimeException("Category not found");
        }

        category.add(new FoodItem(id, name, price));
    }

    public void displayMenu() {
        root.render("");
    }

    private MenuCategory findCategoryById(Menu menu, int id) {

        if (menu instanceof MenuCategory category) {

            if (category.getId() == id) {
                return category;
            }

            for (Menu child : category.getMenu()) {
                MenuCategory result = findCategoryById(child, id);

                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public FoodItem findFoodItem(int id) {
        return findFoodItemById(root, id);
    }

    private FoodItem findFoodItemById(Menu menu, int id) {

        if (menu instanceof FoodItem item) {
            if (item.getId() == id) {
                return item;
            }
        }

        if (menu instanceof MenuCategory category) {
            for (Menu child : category.getMenu()) {
                FoodItem result = findFoodItemById(child, id);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    public Menu getMenu()  {
        return root;
    };
}