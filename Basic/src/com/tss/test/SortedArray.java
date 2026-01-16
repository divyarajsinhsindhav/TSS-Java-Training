package com.tss.test;

import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
        int array[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter value for position " + i + ":");
            array[i] = scanner.nextInt();
        }
        int[] sortedArray = sortedArray(array);
        for(int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    private static int[] sortedArray(int[] array) {
        int n = array.length;
        int result[] = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while(left <= right) {
            int left_square = array[left] * array[left];
            int right_square = array[right] * array[right];

            if (left_square > right_square) {
                result[index] = left_square;
                left++;
            } else {
                result[index] = right_square;
                right--;
            }
            index--;
        }
        return result;
    }
}
