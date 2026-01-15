package com.tss.test;

import java.util.Random;
import java.util.Scanner;

public class GussNumber {
    public static void main(String[] args) {
        int MAX_ATTAMPT = 5;
        int attempt_countr = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int MIN = 1;
        int MAX = 100;

        int randomNumber = random.nextInt((MAX - MIN  + 1)) + MIN;
        System.out.println("Random number: " + randomNumber);

        while (MAX_ATTAMPT > 0) {

            System.out.println("Guess the number: ");
            int gussedNumber = scanner.nextInt();

            if (gussedNumber <= 0 || gussedNumber > 100) {
                System.out.println("Number must be in between 1 to 100");
            }

            if (gussedNumber > randomNumber) {
                System.out.println("Guessed number is too high");
                MAX_ATTAMPT--;
                attempt_countr++;
            } else if (gussedNumber < randomNumber) {
                System.out.println("Guessed number is too low");
                MAX_ATTAMPT--;
                attempt_countr++;
            } else if (gussedNumber == randomNumber) {
                attempt_countr++;
                System.out.println("You Won");
                System.out.println("Your total Attempt: " + attempt_countr);
                System.out.println("Do you want to play again(Y or N): ");
                char answer = scanner.next().charAt(0);

                if (answer == 'Y' || answer == 'y') {
                    MAX_ATTAMPT = 5;
                    attempt_countr = 0;
                    randomNumber = random.nextInt((MAX - MIN  + 1)) + MIN;
                    System.out.println("Random number: " + randomNumber);
                } else {
                    break;
                }
            }

            if (MAX_ATTAMPT == 0) {
                System.out.println("You loose");
                System.out.println("Do you want to play again(Y or N): ");
                char answer = scanner.next().charAt(0);

                if (answer == 'Y' || answer == 'y') {
                    MAX_ATTAMPT = 5;
                    attempt_countr = 0;
                    randomNumber = random.nextInt((MAX - MIN  + 1)) + MIN;
                    System.out.println("Random number: " + randomNumber);
                } else if (answer == 'N' || answer =='n') {
                    break;
                } else {
                    System.out.println("Answer must be Y or N.");
                }
            }
        }

    }
}
