package com.evalution.test;

import com.evalution.model.InvalidAgeException;
import com.evalution.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.*;
import java.util.stream.Stream;

interface Test2 {
    void test();
    static int getAge() {
        return 1;
    };
}

class TestThread extends Thread {
    public void run() {
        System.out.println("Testing thread");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Test {
    public static Integer test() {
        return 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        TestThread t1 = new TestThread();
        t1.start();
        t1.join();
        Thread t2 = new Thread(() -> {
            Runnable r1 = new Runnable() {
                public void run() {
                    System.out.println("Testing runnable");
                }
            };
            r1.run();
        });
        t2.start();
//        try {
//            Student student = new Student("Divyarajsinh", 10);
//        } catch (InvalidAgeException e) {
//            System.out.println(e.getMessage());
//        }
//
//        Consumer<Integer> consumer = (a) -> System.out.println(a);
//        consumer.accept(1);
//
//        Supplier<Integer> supplier = () -> 5+5;
//        System.out.println(supplier.get());
//
//        Function<Integer, Integer> function = (a) -> a*a;
//        System.out.println(function.apply(5));
//
//        Predicate<Integer> predicate = (a) -> a%2==0;
//        System.out.println(predicate.test(5));
//



        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            System.out.println("Testing executor");
        });

//        File file = new File("student.txt");
//        if (file.createNewFile()) {
//            System.out.println("Student file has been created");
//        }
//
//        FileWriter fw = new FileWriter(file);
//        fw.write("Hello java");
//
//        fw.close();
//
//        FileReader fr = new FileReader("student.txt");
//        int i = fr.read();
//        while (i != -1) {
//            System.out.println((char) i);
//            i = fr.read();
//        }
//
//        fr.close();
//
//        BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
//        bw.write("Hello java");
//        bw.close();
//        BufferedReader br = new BufferedReader(new FileReader("student.txt"));
//
//        while(br.readLine() != null){
//            System.out.println(br.readLine());
//        }
    }

}
