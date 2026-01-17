package com.tss.test;

import java.util.Scanner;

public class MatrixOperation {

    public static Scanner scanner = new Scanner(System.in);
    public static int row;
    public static int col;
    public static int[][] matrix;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Matrix");
            System.out.println("2. Display Matrix");
            System.out.println("3. Addition");
            System.out.println("4. Multiplication");
            System.out.println("5. Check Magical Matrix");
            System.out.println("6. Check Prime Harmonic");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createMatrix();
                    break;
                case 2:
                    displayMatrix(matrix);
                    break;
                case 3:
                    addition();
                    break;
                case 4:
                    multiplication();
                    break;
                case 5:
                    boolean resultOfMagicalMatrix = checkMagicalMatrix(matrix);
                    if (resultOfMagicalMatrix) {
                        System.out.println("Given matrix is magical matrix");
                    } else {
                        System.out.println("Given matrix is not magical matrix");
                    }
                    break;
                case 6:
                    boolean resultOfPrimeHarmonic = checkPrimeHarmonic(matrix);
                    if (resultOfPrimeHarmonic) {
                        System.out.println("Given matrix is prime harmonic");
                    } else {
                        System.out.println("Given matrix is not prime harmonic");
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void createMatrix() {
        System.out.print("Enter rows: ");
        row = scanner.nextInt();
        System.out.print("Enter columns: ");
        col = scanner.nextInt();

        matrix = new int[row][col];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not created yet!");
            return;
        }

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void addition() {
        if (matrix == null) return;

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix[i][j] + matrix[i][j];
            }
        }

        System.out.println("Addition Result:");
        displayMatrix(result);
    }

    private static void multiplication() {
        if (matrix == null) return;

        System.out.print("Enter columns for second matrix: ");
        int secondMatrixCol = scanner.nextInt();

        int[][] secondMatrix = new int[col][secondMatrixCol];

        System.out.println("Enter second matrix elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < secondMatrixCol; j++) {
                secondMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[col][secondMatrixCol];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < secondMatrixCol; j++) {
                for (int k = 0; k < col; k++) {
                    result[i][j] += matrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        System.out.println("Multiplication Result:");
        displayMatrix(result);
    }

    private static boolean checkMagicalMatrix(int[][] matrix) {
        boolean flag = false;
        if(row != col) {
            System.out.println("For magic square, matrix must be of same row and column");
            return false;
        }

        int initialRowSum = 0;
        for (int i = 0; i < col; i++) {
            initialRowSum += matrix[0][i];
        }

        int rowSum;
        int colSum;
        for (int i = 0; i < row; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < col; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][row-1-i];
            }
            if (rowSum == initialRowSum && colSum == initialRowSum) {
                flag = true;
            } else {
                flag = false;
                return flag;
            }
        }

        int diagonalSum = 0;
        for (int j = 0; j < row; j++) {
            diagonalSum += matrix[j][j];
        }
        if (diagonalSum == initialRowSum) {
            flag = true;
        } else {
            flag = false;
            return flag;
        }

        diagonalSum = 0;
        for (int j = 0; j < row; j++) {
            diagonalSum += matrix[j][row-1-j];
        }
        if (diagonalSum == initialRowSum) {
            flag = true;
        } else {
            flag = false;
            return flag;
        }

        return true;
    }

    private static boolean checkPrimeHarmonic(int[][] matrix) {
        boolean flag = false;
        if (matrix[0].length < 3) {
            return false;
        }
        int primeCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isPrime = checkPrime(matrix, i, j);
                if (isPrime) {
                    primeCount++;
                }
            }
            if (primeCount == 3) {
                flag = true;
                primeCount=0;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPrime(int[][] matrix, int i, int j) {
        boolean isPrime = true;
        if (matrix[i][j] == 0 || matrix[i][j] == 1) {
            isPrime = false;
            return isPrime;
        }
        for (int k = 2; k < matrix[i][j]/2; k++) {
            if (matrix[i][j]%k == 0) {
                isPrime = false;
                return isPrime;
            }
        }
        return isPrime;
    }
}

