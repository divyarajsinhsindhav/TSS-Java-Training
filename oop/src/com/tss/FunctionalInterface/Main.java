package com.tss.FunctionalInterface;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isOdd = n -> n%2!=0;
        checkOdd(5, isOdd);

        BiFunction<Integer, Integer, Integer> addition = (a, b) -> a+b;
        Integer a = 1;
        Integer b = 2;
        doAddition(a, b, addition);

        Consumer<Integer> square = n -> System.out.println(n * n);
        doSquare(2, square);

        Supplier<LocalDate> todaysDate = () -> LocalDate.now();
        getTodaysDate(todaysDate);

    }

    public static void checkOdd(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println(number + " is Odd");
        } else {
            System.out.println(number + " is Even");
        }
    }

    public static void getTodaysDate(Supplier<LocalDate> date) {
        System.out.println(date.get());
    }

    public static void doAddition(Integer a, Integer b, BiFunction<Integer, Integer, Integer> addition) {
        System.out.println(addition.apply(a, b));
    }

    public static void doSquare(int a, Consumer<Integer> square) {
        square.accept(a);
    }

}
