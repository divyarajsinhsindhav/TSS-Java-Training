package com.foodapp.service;

import com.foodapp.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuService {

    private final Menu root;

    public MenuService() {
        this.root = new MenuCategory(0, "FOOD MENU");
    }

    public Menu getRoot() {
        return root;
    }

    public void addCategory(int parentId, int id, String categoryName) {

        Menu parent = findCategoryById(root, parentId);

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
        System.out.println("\n==================================================");
        System.out.println("                     RESTAURANT MENU                ");
        System.out.println("==================================================\n");
        root.render("");
        System.out.println("\n==================================================");
    }

    private MenuCategory findCategoryById(Menu menu, int id) {

        if (!(menu instanceof MenuCategory category)) {
            return null;
        }

        if (category.getId() == id) {
            return category;
        }

        return category.getMenu()
                .stream()
                .map(child -> findCategoryById(child, id))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public MenuCategory findCategoryByName(int parentCategoryId, String name) {
        MenuCategory parentCategory = findCategoryById(root, parentCategoryId);
        if (parentCategory == null || name == null) {
            return null;
        }

        return parentCategory.getMenu().stream()
                .filter(item -> item instanceof MenuCategory)
                .map(item -> (MenuCategory) item)
                .filter(c -> c.getCategory().equalsIgnoreCase(name.trim()))
                .findFirst()
                .orElse(null);
    }

    public FoodItem findFoodItemByName(String name) {
        if (name == null) {
            return null;
        }
        return getFoodItems().stream()
                .filter(n -> n.getName().equalsIgnoreCase(name.trim()))
                .findFirst()
                .orElse(null);
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
    }

    public List<FoodItem> getFoodItems() {
        List<FoodItem> items = new ArrayList<>();
        collectFoodItems(root, items);
        return items;
    }

    private void collectFoodItems(Menu menu, List<FoodItem> items) {

        if (menu instanceof FoodItem foodItem) {
            items.add(foodItem);
            return;
        }

        if (menu instanceof MenuCategory category) {
            for (Menu child : category.getMenu()) {
                collectFoodItems(child, items);
            }
        }
    }

    public List<MenuCategory> getCategory() {
        List<MenuCategory> categories = new ArrayList<>();
        collectCategories(root, categories);
        return categories;
    }

    private void collectCategories(Menu menu, List<MenuCategory> categories) {

        if (menu instanceof MenuCategory category) {
            categories.add(category);

            for (Menu child : category.getMenu()) {
                collectCategories(child, categories);
            }
        }
    }
}