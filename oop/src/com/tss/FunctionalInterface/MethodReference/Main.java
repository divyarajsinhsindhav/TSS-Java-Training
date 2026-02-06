package com.tss.FunctionalInterface.MethodReference;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> addition = Addition::add;
        System.out.println(addition.apply(1, 2));

        MessagePrinter messagePrinter = new MessagePrinter();
        Consumer<String> printMessage = messagePrinter::print;
        printMessage.accept("Hello World");

        Supplier<Student> supplier = Student::new;
        Student s = supplier.get();

        Function<String, Student> function = Student::new;
        Student student = function.apply("Divyarajsinh");
        System.out.println(student.getName());
    }
}
