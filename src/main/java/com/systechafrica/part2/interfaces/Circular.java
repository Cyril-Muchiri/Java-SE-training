package com.systechafrica.part2.interfaces;

public interface Circular {
   final double PI = 3.142;

   // define all circular shapes
   default double circularArea(double radius) {

      return Math.pow(radius, 2) * PI;
   }

   default double circularPerimeter(double radius) {
      return PI * (2 * radius);
   }
   void ratio(double area, double perimerter);
   String  label();

}
