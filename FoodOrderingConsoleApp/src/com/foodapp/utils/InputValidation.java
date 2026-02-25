package com.foodapp.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidation {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[6-9][0-9]{9}$"); // Indian 10-digit phone

    public static int readPositiveInt(Scanner sc, String message) {
        int value;

        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Value must be greater than 0.");
                }
            } else {
                System.out.println("Invalid number.");
                sc.next();
            }
        }
    }

    public static int readPositiveZeroInt(Scanner sc, String message) {
        int value;

        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Value must be greater than 0.");
                }
            } else {
                System.out.println("Invalid number.");
                sc.next();
            }
        }
    }

    public static int readIntInRange(Scanner sc, String message, int min, int max) {
        int value;

        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Enter value between "
                            + min + " and " + max);
                }
            } else {
                System.out.println("Invalid number.");
                sc.next();
            }
        }
    }

    public static double readPositiveDouble(Scanner sc, String message) {
        double value;

        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Value must be greater than 0.");
                }
            } else {
                System.out.println("Invalid number.");
                sc.next();
            }
        }
    }

    public static String readValidEmail(Scanner sc, String message) {
        String email;

        while (true) {
            System.out.print(message);
            email = sc.next();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            } else {
                System.out.println("Invalid email format.");
            }
        }
    }

    public static String readValidPhone(Scanner sc, String message) {
        String phone;

        while (true) {
            System.out.print(message);
            phone = sc.next();
            if (PHONE_PATTERN.matcher(phone).matches()) {
                return phone;
            } else {
                System.out.println("Invalid phone number. Must be 10 digits.");
            }
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
}