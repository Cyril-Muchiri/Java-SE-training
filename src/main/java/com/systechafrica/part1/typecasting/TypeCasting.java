package com.systechafrica.part1.typecasting;

public class TypeCasting {
    public static void main(String[] args) {

        byte myByte = 2;
        short myShort = 3;
        int myInt = 4;
        long myLong = 5;
        float myFloat = 6.0f;
        double myDouble = 10.0;

        // * cast appropriate data types
        // myShort = myByte;
        // myInt = myShort + myByte;
        // myLong = myInt;
        // myFloat = myLong;
        myDouble=myFloat+myLong+myInt+myShort;
        
        System.out.println(myDouble);
    }

}
