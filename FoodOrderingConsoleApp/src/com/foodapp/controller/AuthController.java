package com.foodapp.controller;

import com.foodapp.model.User;
import com.foodapp.model.UserType;
import com.foodapp.repository.UserRepository;
import com.foodapp.utils.InputValidation;

import java.util.Scanner;

public class AuthController {
    private UserRepository userRepository;
    private Scanner scanner = new Scanner(System.in);

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserType role) {
        String name = InputValidation.readValidName(scanner, "Enter your name: ");
        String email = InputValidation.readValidEmail(scanner, "Enter your email: ");
        User user;
        user = userRepository.getUserByEmail(email);
        if (user != null) {
            throw new IllegalArgumentException("User already exists");
        }
        String password = InputValidation.readNonEmptyString(scanner, "Enter password: ");
        switch (role) {
            case ADMIN ->
            case CUSTOMER ->
            case DELIVERY_PARTNER ->
        }
    }
}
