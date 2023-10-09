package com.systechafrica.part3.generics;

public class Printer {
    public static void main(String[] args) {
        GenericPrinter printer = new GenericPrinter("Kamau");
        GenericPrinter<Double> printer2 = new GenericPrinter(2000.87);
        GenericPrinter <Integer> printer3 =new GenericPrinter<Integer>(10000);

        System.out.println(printer.print());
        System.out.println(printer2.print());
        System.out.println(printer3.print());

        GenericPrinter.print("Manure");
        GenericPrinter.print(100000);
    }
}
