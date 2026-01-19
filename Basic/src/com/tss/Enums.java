package com.tss;
import java.util.Scanner;

public class Enums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Month month = Month.fromMonth(number);
        if (month == null) {
            System.out.println("Enter valid month number");
            return;
        }
        String monthName = month.getName();
        int monthDays = month.getDays();
        int monthNumber = month.getNumber();
        System.out.println("Month is " + monthName + " and it has " + monthDays + " days");
    }
}

enum Month {
    JANUARY(1, "January", 31),
    FEBRUARY(2, "February", 28),
    MARCH(3, "March", 31),
    APRIL(4, "April", 30),
    MAY(5, "May", 31),
    JUNE(6, "June", 30),
    JULY(7, "July", 31),
    AUGUST(8, "August", 31),
    SEPTEMBER(9, "September", 30),
    OCTOBER(10, "October", 31),
    NOVEMBER(11, "November", 30),
    DECEMBER(12, "December", 31);


    private final int number;
    private final String name;
    private final int days;

    Month(int number, String name, int days) {
        this.number = number;
        this.name = name;
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static Month fromMonth(int number) {
        for (Month m : Month.values()) {
            if (m.number == number) {
                return m;
            }
        }
        return null;
    }
}