package com.systechafrica.part3.collections;

import java.util.HashSet;
import java.util.Set;

public class SetsDemo {

    public static void main(String[] args) {

        Set<Object> setOfNames = new HashSet<>();

        StringBuilder sergernt = new StringBuilder("Kimaiyu");
        // ?sets do not allow duplicates
        setOfNames.add("Kimani");
        setOfNames.add(sergernt);
        setOfNames.add(sergernt);
        setOfNames.add(100);
        setOfNames.add("Constable");

        setOfNames.remove("Kimani");
        int length = setOfNames.size();
        // setOfNames.clear();//clears all elements in the set
        setOfNames.contains(sergernt);

        for (Object object : setOfNames) {
            System.out.println(object);
        }
        // using a lambda
        System.out.println("This is by using a for each method and lambda");
        setOfNames.forEach(System.out::println);

        // using an interator interface
        System.out.println("This is by using an iterator");
        java.util.Iterator<Object> objIterator = setOfNames.iterator();
        while (objIterator.hasNext()) {
            System.out.println(objIterator.next());
        }

        System.out.println(setOfNames);
        System.out.println(length);
    }
}
