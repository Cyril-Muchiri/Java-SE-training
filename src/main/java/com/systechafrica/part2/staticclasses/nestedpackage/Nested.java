package com.systechafrica.part2.staticclasses.nestedpackage;

import static  com.systechafrica.part2.staticclasses.AtmUtils.maskNumber;
public class Nested {
    public static void main(String[] args) {
        String cardNumber="123456789123456";
        System.out.println(maskNumber(cardNumber));
    }

}
