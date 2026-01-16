package com.tss.test;

import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        int array[] = new int[7];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<array.length; i++) {
            System.out.println("Enter value for position " + i + ":");
            array[i] = scanner.nextInt();
        }

        int peak = peakElement(array);
        System.out.println("Peak: " + peak);
    }

    private static int peakElement(int[] array) {
        int peak = 0;
        int max_peak = 0;
        for (int i = 1; i < array.length-1; i++) {
            if (array[i-1]<=array[i] && array[i]>=array[i+1]) {
                peak = array[i];
                if (peak > max_peak) {
                    max_peak = peak;
                }
            }
        }
        return max_peak;
    }
}
