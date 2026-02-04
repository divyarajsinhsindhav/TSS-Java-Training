package com.tss.library.service;

import com.tss.library.model.Category;
import com.tss.library.model.Library;

public class CategoryService {
    private static Library library = null;

    public CategoryService(Library library) {
        CategoryService.library = library;
    }

    public static void displayAllCategory() {

        System.out.printf("%-5s %-20s%n", "No.", "Category");
        System.out.println("-----------------------------");

        Category[] categories = Category.values();

        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%-5d %-20s%n",
                    i + 1,
                    categories[i].getDisplayName());
        }
    }

}
