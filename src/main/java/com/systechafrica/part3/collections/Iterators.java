package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
  public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kim");
        names.add("Key");
        names.add("Kardashian");
        names.add("Moses");
        names.add("Dan");

        System.out.println(names.size());

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {

            String element= iterator.next();
            System.out.println(element);
        }

    }
}
