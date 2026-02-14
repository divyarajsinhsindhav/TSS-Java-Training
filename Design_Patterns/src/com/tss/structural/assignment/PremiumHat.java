package com.tss.structural.assignment;

import com.tss.structural.assignment.IHat;

public class PremiumHat implements IHat {

    @Override
    public String getItemName() {
        return "Premium Hat";
    }

    @Override
    public String getItemColor() {
        return "Brown";
    }

    @Override
    public String getDescription() {
        return "Premium Hat with Brown Color";
    }
}
