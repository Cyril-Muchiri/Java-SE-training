package com.systechafrica.part3.generics;

public class GenericPrinter<Thing> {
    private Thing thingToPrint;

    public GenericPrinter(Thing thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public Thing print() {
        return thingToPrint;
    }

    // generic method
    public static <Thing> void print(Thing thing) {
        System.out.println(thing + " was printed");
    }
}
