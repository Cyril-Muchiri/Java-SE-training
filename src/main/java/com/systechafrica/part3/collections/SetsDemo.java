package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo {

    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numberList.add(i);
            numberList.add(i - 1);
        }

        System.out.println("This is the list with duplicates");
        // numberList.forEach(System.out::println);

        System.out.println("This is the size of our numberList: " + numberList.size());

        Set<Integer> nonDupIntegers = new HashSet<>(numberList);// no duplicates

        System.out.println("This is the list after duplicates are deleted");
        for (Integer integer : nonDupIntegers) {
            // System.out.println(integer + "*");
        }

        Set<Object> setOfNames = new HashSet<>();
        // Set<Object> setOfNames = new TreeSet<>();//? output follows a natural order
        // Set<Object> setOfNames = new LinkedHashSet()<>();//? output follows insertion
        // order

        StringBuilder sergernt = new StringBuilder("Kimaiyu");
        // ?sets do not allow duplicates
        setOfNames.add("Kimani");
        setOfNames.add(sergernt);
        setOfNames.add(sergernt);
        setOfNames.add(100);
        setOfNames.add("Constable");
        System.out.println("hashset out");
        System.out.println(setOfNames);
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
