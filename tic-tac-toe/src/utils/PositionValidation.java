package utils;

import java.util.Scanner;

public class PositionValidation {
    Scanner scanner = new Scanner(System.in);
    public int readNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }
}
