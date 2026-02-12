package com.tss.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 7, 6, 5, 4, 3, 2);

        list.stream().forEach(System.out::println);

        list.stream().filter(number -> number%2==0).forEach(System.out::println);

        list.stream().filter(number -> number%2==0).map(number -> number*number).forEach(System.out::println);

        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        boolean hasAnyOddAndDivisibleOfThree = list.stream().anyMatch(number -> number%2!=0 && number/3==0);
        System.out.println(hasAnyOddAndDivisibleOfThree);

        boolean allPositive = list.stream().allMatch(n -> n > 0);
        System.out.println(allPositive);

        boolean noneNegative = list.stream().noneMatch(n -> n < 0);
        System.out.println(noneNegative);

        list.stream().sorted().forEach(System.out::println);

        list.stream().limit(3).forEach(System.out::println);

        list.stream()
                .peek(n -> System.out.println("Original: " + n));

    }
}
