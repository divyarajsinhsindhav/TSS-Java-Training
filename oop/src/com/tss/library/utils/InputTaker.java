package com.tss.library.utils;

import java.util.Scanner;

public class InputTaker {
    private static final Scanner scanner = new Scanner(System.in);

    private InputTaker() {}

    // ---------- INT ----------

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                return value;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Value must be between " + min + " and " + max + ".");
        }
    }

    public static int readInt(String prompt, int min) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min) {
                return value;
            }
            System.out.println("Value must be greater than or equal to " + min + ".");
        }
    }

    // ---------- DOUBLE ----------

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static double readDouble(String prompt, int min) {
        while (true) {
            double value = readDouble(prompt);
            if (value >= min) {
                return value;
            }
            System.out.println("Value must be greater than or equal to " + min + ".");
        }
    }

    public static double readDouble(String prompt, int min, int max) {
        while (true) {
            double value = readDouble(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Value must be between " + min + " and " + max + ".");
        }
    }

    // ---------- STRING ----------

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static String readName(String prompt) {
        while (true) {
            String name = readString(prompt);
            if (name.matches("[A-Za-z ]+")) {
                return name;
            }
            System.out.println("Invalid name. Use letters and spaces only.");
        }
    }

    public static String readEmail(String prompt) {
        while (true) {
            String email = readString(prompt); // assuming readString(prompt) already exists
            // Simple regex for email validation
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return email;
            }
            System.out.println("Invalid email. Enter a valid email address.");
        }
    }


    // ---------- BOOLEAN ----------

    public static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt + " (true/false or y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true") || input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.equals("false") || input.equals("n") || input.equals("no")) {
                return false;
            }

            System.out.println("Invalid input. Please enter true/false or y/n.");
        }
    }
}
