package com.tss.model;

public class Rectangle extends Shape{
    double l;
    double w;
    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }
    @Override
    public void area() {
        System.out.println("Area of rectangle is: " + this.l*this.w);
    }
}
