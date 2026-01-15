package com.tss.test;
import java.util.Scanner;

public class FindMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number_1:");
        int num_1= scanner.nextInt();
        System.out.println("Enter Number_2:");
        int num_2= scanner.nextInt();
        System.out.println("Enter Number_3:");
        int num_3= scanner.nextInt();

        if(num_1 > num_2 && num_1 > num_3) {
            System.out.println("Number 1 is Maximum");
        } else if(num_2 > num_1 && num_2 > num_3) {
            System.out.println("Number 2 is Maximum");
        } else {
            System.out.println("Number 3 is Maximum");
        }

    }
}
