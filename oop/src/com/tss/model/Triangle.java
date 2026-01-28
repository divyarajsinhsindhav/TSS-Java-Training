package com.tss.model;

public class Triangle extends Shape {
    double base;
    double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void area() {
        System.out.println("Area of triangle is: " + (1/2)*base*height);
    }
}
