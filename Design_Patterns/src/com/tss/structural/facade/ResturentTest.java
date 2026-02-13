package com.tss.structural.facade;

import com.tss.structural.facade.controller.Reception;
import com.tss.structural.facade.services.LuggageService;
import com.tss.structural.facade.services.RestaurantService;
import com.tss.structural.facade.services.RoomSerives;

public class ResturentTest {
    public static void main(String[] args) {
        LuggageService luggageService = new LuggageService();
        RestaurantService restaurantService = new RestaurantService();
        RoomSerives roomSerives = new RoomSerives();

        Reception reception = new Reception(luggageService, restaurantService, roomSerives);
        reception.checkIn();
        reception.orederFood();
        reception.checkOut();
    }
}
