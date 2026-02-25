package com.foodapp.controller;

import com.foodapp.service.MenuService;

public class MenuController {
    private MenuService menuService;
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void displayMenu() {

    }

    public void displayItems() {
        menuService.getFoodItems()
                .stream()
                .forEach(foodItem -> {
                    System.out.println("Id: " +  foodItem.getId() +
                            "\nItem: " + foodItem.getName() +
                            "\nPrice: " + foodItem.getPrice());
                });
    }

    public void displayCategory() {
        menuService.getCategory()
                .stream()
                .forEach(category -> {
                    System.out.println("Id: " + category.getId() +
                            "->: " + category.getCategory());
                });
    }
}
