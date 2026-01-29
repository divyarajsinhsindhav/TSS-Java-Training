package com.tss.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        int n = 10;
        int m = 0;

        /**
         * TRY block:
         * Code that may cause an exception is placed here.
         * Division by zero may occur.
         */
        try {
            int ans = n / m; // Risky operation
            System.out.print(ans);
        }

        /**
         * CATCH block:
         * Handles ArithmeticException if division by zero occurs.
         * Prevents program from crashing.
         */
        catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // Prints exception message
        }

        /**
         * FINALLY block:
         * Always executes whether exception occurs or not.
         * Commonly used for cleanup code (closing files, DB connections).
         */
        finally {
            System.out.println("After catch it always execute.");
        }

        /**
         * Method call that may throw ArithmeticException.
         * This exception is not handled here, so it propagates.
         */
        performDivision(n, m);

        /**
         * Manually throwing an exception using 'throw' keyword.
         * Used for custom validation.
         */
        if (m == 0) {
            throw new ArithmeticException("m Must be non zero");
        }

        // This line will not execute if exception is thrown above
        System.out.println("Programme continue....");
    }

    /**
     * Performs division of two integers.
     *
     * @param n numerator
     * @param m denominator
     * @return result of division
     * @throws ArithmeticException if m is zero
     */
    public static int performDivision(int n, int m) throws ArithmeticException {
        return n / m;
    }
}
