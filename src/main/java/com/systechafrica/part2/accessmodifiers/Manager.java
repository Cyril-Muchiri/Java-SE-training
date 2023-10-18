package com.systechafrica.part2.accessmodifiers;

import java.util.Scanner;
import java.util.UUID;

public class Manager {
    private Scanner scan = new Scanner(System.in);

    public void registerEmployee() {
        boolean availability;
        System.out.println("Enter Employee name: ");

        String name = scan.nextLine();

        String id = UUID.randomUUID().toString();

        System.out.println("Are you available: y/n ");
        String choice = scan.nextLine();
        if (choice.equals("y".toLowerCase())) {
            availability = true;
        } else {
            availability = false;
        }
        Employee employee1 = new Employee(name, id, availability);
        scan.close();

        System.out.println(employee1.toString());

    }

    public static void main(String[] args) {
        Manager man = new Manager();
        man.registerEmployee();
    }

}
