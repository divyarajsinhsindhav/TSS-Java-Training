package com.tss.test;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number:");
        int input = scanner.nextInt();

        int length = 0;
        int temp = input;

        int sum = 0;
        while(temp>0) {
            temp = temp / 10;
            length++;
        }

        int temp_number = input;
        while(temp_number>0) {
            int mod = temp_number%10;
            sum += (int)Math.pow(mod, length);
            temp_number = temp_number/10;
        }
        if (sum == input) {
            System.out.println("Number is Armstrong");
        } else {
            System.out.println("Number is not Armstrong");
        }
    }
}
