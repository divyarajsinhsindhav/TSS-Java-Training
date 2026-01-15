package com.tss.test;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        playGame();

    }

    private static int singleGame(int current_score, int current_turn) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 6;

        System.out.println("---------- Turn " + current_turn + " ----------");

        while(true) {
           System.out.println("Roll or Hold? (r/h)");
           char user_input = scanner.next().charAt(0);

           if (user_input == 'h') {
               return current_score;
           }

           int random_number = random.nextInt((MAX_NUMBER - MIN_NUMBER  + 1)) + MIN_NUMBER;

           if (random_number == 1) {
               System.out.println("Number on Dice: " + random_number);
               current_score = 0;
               return current_score;
           }

           current_score += random_number;
           System.out.println("Number on Dice: " + random_number);

           if (current_score >= 20) {
               break;
           }

           continue;
        }
        return current_score;
    }

    private static void playGame() {
        final int MAX_SCORE = 20;
        final int MAX_TURN = 5;
        int current_score = 0;
        int current_turn = 0;

        while(true) {
            while (current_turn < MAX_TURN) {
                current_turn ++;
                current_score = singleGame(current_score, current_turn);

                if (current_score >= MAX_SCORE) {
                    System.out.println("You won.");
                    System.out.println("Your score is " + current_score + " in turn" + current_turn);
                    break;
                }

                System.out.println("Current Score: " + current_score);
                System.out.println("Total Turn: " + current_turn);
            }

            if (current_turn == 5 && current_score < 20) {
                System.out.println("You loose");
            }

            System.out.println("Do you wanna play again(Y or N): ");
            char user_input = scanner.next().charAt(0);
            if (user_input == 'Y' || user_input == 'y') {
                current_score = 0;
                current_turn = 0;
                continue;
            } else {
                break;
            }
        }
    }
}
