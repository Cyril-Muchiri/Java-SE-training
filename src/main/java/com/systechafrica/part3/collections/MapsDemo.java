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

        System.out.println(capitalCity);

    }

}
