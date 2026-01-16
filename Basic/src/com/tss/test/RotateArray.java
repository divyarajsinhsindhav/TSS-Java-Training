package com.tss.test;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = new int[7];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter value for position " + i + ":");
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter rotation value: ");
        int p = scanner.nextInt();

        System.out.println("\nArray before rotation: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

        rotate(array, p);

        System.out.println("\nArray after rotation: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private static void reverse(int array[], int start, int end) {
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotate(int array[], int p){
        int length = array.length;

        p %= length;

        reverse(array, 0, length-1);

        reverse(array, 0, p-1);

        reverse(array, p, length-1);
    }
}
