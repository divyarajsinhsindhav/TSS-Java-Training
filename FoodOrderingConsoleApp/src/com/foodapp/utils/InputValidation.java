package com.foodapp.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidation {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[6-9][0-9]{9}$");

    private InputValidation() {
    }

    // ================= INTEGER VALIDATIONS =================

    public static int readPositiveInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    public static int readPositiveZeroInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= 0) {
                    return value;
                }
                System.out.println("Value must be 0 or greater.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    public static int readIntInRange(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Enter value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    // ================= DOUBLE VALIDATION =================

    public static double readPositiveDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    // ================= STRING VALIDATIONS =================

    public static String readValidEmail(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String email = sc.nextLine().trim();

            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            }

            System.out.println("Invalid email format.");
        }
    }

    public static String readValidPhone(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String phone = sc.nextLine().trim();

            if (PHONE_PATTERN.matcher(phone).matches()) {
                return phone;
            }

            System.out.println("Invalid phone number. Must be 10 digits starting with 6-9.");
        }
    }

    public static String readValidName(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            if (!name.matches("^[A-Za-z ]{2,50}$")) {
                System.out.println("Name must contain only letters and spaces (2-50 characters).");
                continue;
            }

            return name;
        }
    }

    public static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}