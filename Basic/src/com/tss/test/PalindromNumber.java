package com.tss.test;

import java.util.Scanner;

public class PalindromNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int input = scanner.nextInt();

        int temp_number = input;
        int sum = 0;
        while(temp_number>0) {
            int mod = temp_number%10;
            sum = sum*10 + mod;
            temp_number = temp_number/10;
        }

        if (sum == input) {
            System.out.println("Number is palindrom");
        } else {
            System.out.println("Number is not palindrom");
        }
    }
}
