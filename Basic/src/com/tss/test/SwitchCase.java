package com.tss.test;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month number");
        int inputMonth = scanner.nextInt();
        String output;
        switch (inputMonth) {
            case 1: output = "January";
            case 2: output = "February";
            case 3:
            case 4:
            case 5:
            case 6: output = "June"; break;
            case 7: output = "July";
            default: output = "Must be between 1 to 12";
        }
        System.out.print(output);
    }
}
