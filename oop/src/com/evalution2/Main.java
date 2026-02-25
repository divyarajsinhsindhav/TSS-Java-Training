package com.evalution2;

public class Main {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println("Hello World");
        };
        Thread t1 = new Thread(r1);
        t1.start();
        t1.start();
    }
}
