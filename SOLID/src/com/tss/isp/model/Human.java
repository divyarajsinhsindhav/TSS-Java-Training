package com.tss.isp.model;

public class Human implements Workable{
    @Override
    public void doWork() {
        System.out.println("Human is working");
    }

    public void eating() {
        System.out.println("Human is eating");
    }

    public void resting() {
        System.out.println("Human is resting");
    }
}
