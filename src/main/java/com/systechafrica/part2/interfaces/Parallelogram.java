package com.systechafrica.part2.interfaces;

public interface Parallelogram {

    default double parallelogramArea(double length, double height) {
        return length * height;
    }

    default double parallelogramPerimeter(double length, double height) {
        return (length + height) * 2;
    }

    void ratio(double area, double perimerter);

    String  label();
}

