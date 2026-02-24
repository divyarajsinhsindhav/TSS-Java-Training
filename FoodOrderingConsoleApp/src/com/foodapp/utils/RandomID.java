package com.foodapp.utils;

import java.util.Random;

public class RandomID {
    private Random rand = new Random();

    public int getRandomID() {
        return rand.nextInt(900) + 100;
    }
}
