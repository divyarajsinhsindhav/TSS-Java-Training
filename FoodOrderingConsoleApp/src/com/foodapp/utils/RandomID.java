package com.foodapp.utils;

import java.util.Random;

public class RandomID {
    private Random random = new Random();

    public int getRandomID() {
        return random.nextInt(900) + 100;
    }
}
