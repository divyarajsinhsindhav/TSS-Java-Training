package com.foodapp.service;

import com.foodapp.model.FlatDiscount;

public class DiscountService {
    public double applyFlatDiscount(double amount) {
        if (amount > FlatDiscount.getFlatDiscountOn()) {
            return FlatDiscount.getFlatDiscountOn();
        }
        return 0;
    }
}
