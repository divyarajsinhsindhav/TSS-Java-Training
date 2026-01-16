package com.tss.test;

import java.util.Scanner;

public class MatrixOperation {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter size of m: ");
        int m = scanner.nextInt();
        System.out.println("Enter size of n: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        int[][] secondMatrix = new int[n][m];

        while(true) {
            System.out.println("\n1. Create array \n2. Display Array \n3. Addition \n4. Multiplication");
            System.out.println("\nEnter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createMatrix(m, n, matrix);
                    break;
                case 2:
                    displayMatrix(m, n, matrix);
                    break;
                case 3:
                     addition(m, n, matrix);
                     break;
                case 4:
                    multiplication(m, n, matrix, secondMatrix);
                    break;
                default:
                    continue;
            }
        }
    }

    private static void createMatrix(int m, int n, int[][] matrix) {
        System.out.println("Enter elements of matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matrix["+i+"]["+j+"]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void displayMatrix(int m, int n, int[][] matrix) {
        System.out.println("Matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void addition(int m, int n, int[][] matrix) {
        int[][] additionMatrix = new int[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                additionMatrix[i][j] = matrix[i][j] + matrix[i][j];
            }
        }
        displayMatrix(m, n, additionMatrix);
    }
    private static void multiplication(int m, int n, int[][] matrix, int[][] secondMatrix) {
        createMatrix(n, m, secondMatrix);
        int x = matrix.length;
        int y = matrix[0].length;
        int z = secondMatrix[0].length;
        int[][] result = new int[x][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        displayMatrix(x, z, result);

    }
}
