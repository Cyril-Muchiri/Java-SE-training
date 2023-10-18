package com.systechafrica.part3.collections;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {
    // !Maps is an interface common implememntors of the interface include a hashset
    public static void main(String[] args) {
        // * maps store a key - value pair
        Map<Object, String> capitalCity = new HashMap<>();
        Country Kenya = new Country("Kenya");
        Country Tanzania = new Country("Tanzania");
        Country Uganda = new Country("Uganda");

        capitalCity.put(Kenya.toString(), " Nairobi");
        capitalCity.put(Tanzania.toString(), " Dar-es-salam");
        capitalCity.put(Uganda.toString(), " Kampala");

        //?getting from a map
        System.out.println(capitalCity.get(Kenya.toString()));

        //?contains value/key -> boolean
        System.out.println(capitalCity.containsKey(Tanzania.toString()));
        System.out.println(capitalCity.containsValue(Kenya));

        //?put if absent
        capitalCity.putIfAbsent(new Country("Rwanda"), " Kigali");


        System.out.println(capitalCity);

    }

}
