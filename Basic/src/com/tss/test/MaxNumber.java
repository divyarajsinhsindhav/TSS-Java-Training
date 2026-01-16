package com.tss.test;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        System.out.println("Enter array element: ");
        int array[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<array.length; i++) {
            System.out.println("Enter value for position " + i + ":");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Max number is " + max);

    }
}
