package com.tss.model;

public class Circle extends Shape{
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public void area() {
        System.out.println("Area of circle is: " + (3.14)*this.radius*this.radius);
    }
}
