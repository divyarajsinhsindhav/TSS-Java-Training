package com.tss.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class StudentAssignment {
    public static void main(String[] args) {
        String[] names = {"Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh"};

        System.out.println("1. First 3 students sorted ascending");
        sort(names, 3, true);

        System.out.println("\n2. First 3 students sorted ascending (contains 'a'):");
        ascSortContains(names, 3, "a");

        System.out.println("\n3. Students in descending order:");
        sort(names, names.length, false);

        System.out.println("\n4. First 3 characters of all names:");
        numberOfCharOfName(names,3);

        System.out.println("\n5. Names with length ≤ 4:");
        nameLengthFilter(names, 4);
    }

    public static void sort(String[] names, int limit, boolean asc) {
        if (asc) {
            Arrays.stream(names)
                    .sorted()
                    .limit(limit)
                    .forEach(System.out::println);
            return;

        }
        Arrays.stream(names)
                .sorted(Comparator.reverseOrder())
                .limit(limit)
                .forEach(System.out::println);
    }

    public static void ascSortContains(String[] names, int limit, String string) {
        Arrays.stream(names)
                .filter(name -> name.toLowerCase().contains(string))
                .sorted()
                .limit(limit)
                .forEach(System.out::println);
    }

    public static void numberOfCharOfName(String[] names, int numeberOfChar) {
        Arrays.stream(names)
                .map(name -> name.substring(0, Math.min(numeberOfChar, name.length())))
                .forEach(System.out::println);
    }

    public static void nameLengthFilter(String[] names, int length) {
        Arrays.stream(names)
                .filter(name -> name.length()<=length)
                .forEach(System.out::println);
    }
}
