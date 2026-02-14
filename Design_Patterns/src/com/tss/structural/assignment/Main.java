package com.tss.structural.assignment;

import com.tss.structural.adapter.Hat;

public class Main {
    public static void main(String[] args) {
        IHat hat = new GoldenHat(new StandardHat());
//        System.out.println(hat.getDescription());
//        System.out.println(hat.getItemColor());
//        System.out.println(hat.getItemName());

        IHat hat2 = new GoldenHat(new RibonedHat(new StandardHat()));
        System.out.println(hat2.getDescription());
        System.out.println(hat2.getItemColor());
        System.out.println(hat2.getItemName());
    }
}
