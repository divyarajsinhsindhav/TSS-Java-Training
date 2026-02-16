package com.tss.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(94, "Divyarajsinh", new Associate());
        employee.getResponsibilities();

        employee.setRole(new Junior());
        employee.getResponsibilities();


    }
}
