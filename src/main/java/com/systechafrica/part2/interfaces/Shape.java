package com.systechafrica.part2.interfaces;

public class Shape implements Circular, Parallelogram {
    @Override
    public void ratio(double area, double perimerter) {
        System.out.println(area / perimerter);
        throw new UnsupportedOperationException("Unimplemented method 'ratio'");
    }

    public static void main(String[] args) {
        double circleRadius=3.5;
        double length=10;
        double height=13;
        // ?calculate area of circle
        Shape circle = new Shape();
        System.out.println("The area of the circle is :" + circle.circularArea(circleRadius) + " cm2");
        System.out.println("The Perimeter of the square is :"+circle.circularPerimeter(circleRadius)+ " cm");
        System.out.println("The ratio of area to perimeter is :"
                + circle.circularArea(circleRadius) / circle.circularPerimeter(circleRadius));
                System.out.println();

        // ?calculate area of square
        Shape square = new Shape();
        System.out.println("The area of the square is :" + square.parallelogramArea(length, length) + " cm2");
        System.out.println("The Perimeter of the square is :" + square.parallelogramPerimeter(length, length) + " cm");

        System.out.println("The ratio of area to perimeter is :"
                + square.parallelogramArea(length, length) / square.parallelogramPerimeter(length, length));
System.out.println();

Shape rectangle=new Shape();
 System.out.println("The area of the rectangle is :" + rectangle.parallelogramArea(length, height) + " cm2");
        System.out.println("The Perimeter of the rectangle is :" + rectangle.parallelogramPerimeter(length, height) + " cm");

        System.out.println("The ratio of area to perimeter is :"
                + rectangle.parallelogramArea(length, height) / rectangle.parallelogramPerimeter(length, height));
System.out.println();
    }

    @Override
    public String label() {
        System.out.println("This is a circular object");
        throw new UnsupportedOperationException("Unimplemented method 'label'");
    }

}
