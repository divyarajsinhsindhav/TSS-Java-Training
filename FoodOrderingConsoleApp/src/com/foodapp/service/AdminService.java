package com.foodapp.service;

import com.foodapp.model.Discount;
import com.foodapp.model.FlatDiscount;

public class AdminService {

    public void setDiscountRate(Discount discount, double rate) {
        discount.setDiscount(rate);
    }

    public void setFlatDiscountOn(Discount discount, double rate) {
        FlatDiscount.setFlatDiscountOn(rate);
    }

}
