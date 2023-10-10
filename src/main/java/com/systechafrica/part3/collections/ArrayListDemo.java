package com.systechafrica.part3.collections;

import java.util.ArrayList;

public class ArrayListDemo {

    public <Thing> void displayList(){
 ArrayList <Thing>listOfThings=new ArrayList<>();

    }

    public static void addToArrayList(){
        ArrayList list1=new ArrayList();
        list1.add(10);
        list1.add("John");

        System.out.println(list1);
    }
   
public static void main(String[] args) {
    addToArrayList();
}
}
