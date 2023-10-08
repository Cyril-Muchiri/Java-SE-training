package com.systechafrica.part3.generics;

public class SimpleDemo {
    public static void main(String[] args) {

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        String[] names = { "John", "Cate", "Luis", "Karen" };
        Character[] alphabet = { 'a', 'b', 'c', 'd' };

        displayArray(numbers);
        displayArray(names);
        displayArray(alphabet);

    }

    static <SomeArray> void displayArray(SomeArray[] array) {
        for (SomeArray someArray : array) {
         
            System.out.print(someArray+", ");
            
        }
    }
}
