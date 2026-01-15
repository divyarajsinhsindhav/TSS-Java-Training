package com.tss.test;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number");
        int input = scanner.nextInt();

        int flag = 0;
        for(int i = 2; i<input/2; i++) {
            if(input%i == 0) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("Given number is prime");
        }
        else {
            System.out.println("Given number is not prime");
        }
    }
}
