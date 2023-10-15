package com.systechafrica.part3.collections;

import java.util.HashSet;
import java.util.Set;

public class SetsDemo {
    
    public static void main(String[] args) {
        
        Set<Object>setOfNames= new HashSet<>();

        StringBuilder sergernt=new StringBuilder("Kimaiyu");

        setOfNames.add("Kimani");
        setOfNames.add(sergernt);


        System.out.println(setOfNames);
    }
}
