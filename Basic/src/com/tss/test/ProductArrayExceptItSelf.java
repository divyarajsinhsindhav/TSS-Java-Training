package com.tss.test;

import java.util.Scanner;

public class ProductArrayExceptItSelf {
    public static void main(String[] args) {
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter value for position " + i + ":");
            array[i] = scanner.nextInt();
        }

        int[] result = productExceptItSelf(array);

        System.out.println("Product array except self:");
        for(int val : result) {
            System.out.print(val + " ");
        }
    }

    private static int[] productExceptItSelf(int[] array) {
        int n = array.length;
        int[] result = new int[n];

        int left = 1;
        for(int i = 0; i < n; i++) {
            result[i] = left;
            left *= array[i];
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= array[i];
        }
        return result;
    }
}
