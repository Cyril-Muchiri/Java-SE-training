package com.systechafrica.part3.generics;

import javax.print.attribute.standard.MediaSize.Other;

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

    public static <Thing, Other> void print(Thing thing, Other other) {
        System.out.println(thing + " & " + other + " was printed");
    }
}
