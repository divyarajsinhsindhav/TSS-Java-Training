package com.foodapp.model;

import java.util.List;

public interface Menu {
    default void add(Menu item) {
        throw new UnsupportedOperationException("Not supported yet.");
    };

    default void remove(Menu item) {
        throw new UnsupportedOperationException("Not supported yet.");
    };

    default List<Menu> getMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    };

    void render(String indent);
}
