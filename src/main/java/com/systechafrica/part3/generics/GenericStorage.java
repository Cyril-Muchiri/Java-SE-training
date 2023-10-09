package com.systechafrica.part3.generics;

public class GenericStorage<Thing> {

    // *This is a generic method takes an array of things */
    public  void store(Thing[]things,double quantity) {
        for (Thing thing : things) {
            System.out.println(thing.toString()+" stored of "+quantity+" Kgs");
            // System.out.println(thing);
        }
    }

    // *This is a generic method takes an item as a prameter */
    public  Thing store(Thing thing,double quantity) {
        // System.out.println(thing.toString()+" stored of "+quantity+" Kgs");
        return thing;
    }
}
