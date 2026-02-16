package com.tss.behavioral.strategy;

public class Junior implements Role {
    @Override
    public void getResponsibilities() {
        System.out.println("Write new feature");
    }
}
