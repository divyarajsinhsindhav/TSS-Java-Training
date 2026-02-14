package com.tss.structural.assignment;

import com.tss.structural.assignment.IHat;

public class StandardHat implements IHat {
    @Override
    public String getItemName() {
        return "Standard Hat";
    }

    @Override
    public String getItemColor() {
        return "Black";
    }

    @Override
    public String getDescription() {
        return "Standard Hat With Black color";
    }

}
