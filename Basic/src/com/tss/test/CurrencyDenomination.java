package com.tss.test;

import java.util.Scanner;

public class CurrencyDenomination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount: ");
        int amount = scanner.nextInt();

        int count_2000 = 0;
        int count_500 = 0;
        int count_200 = 0;
        int count_100 = 0;
        if(amount > 50000 || amount%100!=0) {
            System.out.println("Amount must be less than or equal to 50000, and must be multiple of 100");
        } else {
            int temp_amount = amount;
            while(temp_amount > 0) {
                if(temp_amount >= 2000) {
                    temp_amount -= 2000;
                    count_2000++;
                } else if (temp_amount >= 500) {
                    temp_amount -= 500;
                    count_500++;
                } else if (temp_amount >= 200) {
                    temp_amount -= 200;
                    count_200++;
                } else if (temp_amount >= 100) {
                    temp_amount -= 100;
                    count_100++;
                }
            }
            System.out.println("Count_2000:" + count_2000);
            System.out.println("Count_500:" + count_500);
            System.out.println("Count_200:" + count_200);
            System.out.println("Count_100:" + count_100);
        }
    }
}
