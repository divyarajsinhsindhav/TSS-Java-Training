package com.foodapp;

import java.io.Console;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.err.println("No console available");
            System.exit(1);
        }

        String username = console.readLine("Enter your username: ");
        char[] password = console.readPassword("Enter your password: ");

        if (username != null && password != null) {
            console.printf("Hello, %s!%n", username);
            Arrays.fill(password, ' ');
        }
    }
}
