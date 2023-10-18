package com.systechafrica.part2.abstractclasses;

public abstract class Animal implements Behavior {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println("This " + name + " is eating!");
    }
}
