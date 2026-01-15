package com.tss.test;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int input = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= input/2; i++) {
            if (input%i == 0) {
                sum += i;
            }
        }

        if (sum == input) {
            System.out.println("Number is Perfect");
        } else {
            System.out.println("Number is not Perfect");
        }
    }
}
