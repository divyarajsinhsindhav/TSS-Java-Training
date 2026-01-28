package com.tss.test;

import com.tss.model.Circle;
import com.tss.model.Rectangle;
import com.tss.model.Shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape c = new Circle(2);
        c.area();
        Shape r = new Rectangle(1,2);
        r.area();

    }
}
