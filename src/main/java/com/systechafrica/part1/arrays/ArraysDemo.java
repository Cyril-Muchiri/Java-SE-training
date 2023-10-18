package com.systechafrica.part1.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemo {
    private Scanner scan = new Scanner(System.in);
    int mem = 3;

    // StringBuilder names[];
    String names[]=new String[mem];
    int[] age= new int[mem];
    StringBuilder storeNames = new StringBuilder();

    void registerStudent() {
        for (int i = 0; i < mem; i++) {
            // names = new String[mem];
            // age = new int[mem];

            System.out.print("Enter Student name: ");
            // names[i] = scan.nextLine();
            storeNames.append(scan.nextLine());
            storeNames.append(",");
            
            // System.out.println("");
            // scan.nextLine();
            System.out.print("Enter students age: ");
            age[i] = scan.nextInt();
            scan.nextLine();

            // mem++;
        }
        // System.out.println(Arrays.toString(names));
        System.out.println(storeNames);
        System.out.println(Arrays.toString(age));
        scan.close();
    }

    public static void main(String[] args) {
        ArraysDemo a=new ArraysDemo();
a.registerStudent();
        
    }
}