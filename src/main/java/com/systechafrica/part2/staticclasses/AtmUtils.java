package com.systechafrica.part2.staticclasses;

public class AtmUtils {

    public static String maskNumber(String cardNumber) {
        String mask = "XXXXXXXXXXXX";
        String postFix = cardNumber.substring(12, cardNumber.length());
        return mask.concat(postFix);
    }
}
