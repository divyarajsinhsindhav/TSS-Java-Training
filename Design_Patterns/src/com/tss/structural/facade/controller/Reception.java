package com.tss.structural.facade.controller;

import com.tss.structural.facade.services.LuggageService;
import com.tss.structural.facade.services.RestaurantService;
import com.tss.structural.facade.services.RoomSerives;

public class Reception {
    private LuggageService luggageService;
    private RestaurantService restaurantService;
    private RoomSerives roomSerives;

    public Reception(LuggageService luggageService, RestaurantService restaurantService, RoomSerives roomSerives) {
        this.luggageService = luggageService;
        this.restaurantService = restaurantService;
        this.roomSerives = roomSerives;
    }

    public void checkIn() {
        System.out.println("Checking in");
        luggageService.collectLuggage();
        roomSerives.cleanRoom();
    }

    public void orederFood() {
        restaurantService.orderFood();
    }

    public void checkOut() {
        System.out.println("Checking out");
    }
}
