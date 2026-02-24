package com.foodapp.model;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory implements Menu {
    private int id;
    private String category;
    private List<Menu> items = new ArrayList<>();

    public MenuCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void add(Menu item) {
        items.add(item);
    }

    @Override
    public void remove(Menu item) {
        items.remove(item);
    }

    @Override
    public List<Menu> getMenu() {
        return items;
    }

    @Override
    public void render(String indent) {
        System.out.println(indent + category);

        for (Menu item : items) {
            item.render(indent + "   ");
        }
    }
}
