package com.tss.isp.model;

public class Robot implements Workable, Chargeble {
    @Override
    public void doWork() {
        System.out.println("Robots do work");
    }

    @Override
    public void charging() {
        System.out.println("Robot is on charging mode");
    }
}
