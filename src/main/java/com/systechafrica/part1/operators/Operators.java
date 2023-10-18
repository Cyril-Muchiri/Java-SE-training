package com.systechafrica.part1.operators;

public class Operators {

    // contains basic operators
    public int addNumbers(int a, int b, int c) {
        return a + b + c;
    }

    public int multiplyNumbers(int a, int b, int c) {
        return a * b * c;

    }

    public double divideNumbers(double number, double divisor) {
        return number / divisor;
    }

    public int subtractNumbers(int a, int b, int c) {
        return c - b - a;
    }

    public int modulusNumbers(int c, int a) {
        return c % a;
    }

    public static void main(String[] args) {
        int i=0;
        // int j=i++;
        // int k= ++i;

        // System.out.println(" : "+i+j+k);
        System.out.println(++i+5+(++i));
       
    }

}
