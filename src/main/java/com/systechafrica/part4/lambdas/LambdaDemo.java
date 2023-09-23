package com.systechafrica.part4.lambdas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        List <Object> generalItems= new ArrayList<>();

        generalItems.add("Cow");
        generalItems.add(new String("Thesis"));
        generalItems.add(10000);

        Iterator iter=generalItems.iterator();

        while(iter.next()){
            
        }        

    }
}
