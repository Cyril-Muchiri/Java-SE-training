package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List myList=new ArrayList<>() {
            
        };
        Integer a=100;
        String b="Hello";
        Double c=2000.00;
        myList.add(a);
        myList.add(b);
        myList.add(c);

        // myList.remove(0); overloaded list.remove()
        System.out.println(myList.remove(c));
        System.out.println(myList.remove(0));//returns the object at the index specified to be reomved
        System.out.println(myList.remove(c));//returns a boolean 
        System.out.println(myList);

        

    }
}
