package com.systechafrica.part3.generics;

public class SimpleDemo {
    public static void main(String[] args) {

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        String[] names = { "John", "Cate", "Luis", "Karen" };
        Character[] alphabet = { 'a', 'b', 'c', 'd' };

        displayArray(numbers);
        displayArray(names);
        displayArray(alphabet);
System.out.println("");
        GenericStorage store1=new GenericStorage<>();

        Grocery maize=new Grocery();
        maize.setGroceryQuantity(200);
        Grocery beans= new Grocery();
        beans.setGroceryQuantity(100);

        store1.store(beans,beans.getGroceryQuantity());
        store1.store(maize,maize.getGroceryQuantity());



    }

   

    <SomeGroceries> void displayGrocery(Grocery[] item) {
        for (Grocery someGrocery : item) {
            System.out.println(someGrocery);
        }
    }

    static <SomeArray> void displayArray(SomeArray[] array) {
        for (SomeArray someArray : array) {
            System.out.print(someArray + ", ");

        }
    }
}
