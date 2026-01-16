package com.tss.test;

import java.util.Scanner;

public class SecondMax {
    public static void main(String[] args) {
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter value for position " + i + ":");
            array[i] = scanner.nextInt();
        }

        System.out.println("Second maximum number is " + findSecondMax(array));
    }

    private static int findSecondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax && array[i] != max) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }
}
