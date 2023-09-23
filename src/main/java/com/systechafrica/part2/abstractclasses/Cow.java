package com.systechafrica.part2.abstractclasses;

public class Cow  extends Animal{

    public Cow(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void move() {
        System.out.println("This "+name+" is moving");
        
    }

    @Override
    public void feeds() {
        System.out.println("This "+name+" is feeding");
        
    }

    @Override
    public void makeSound() {
        System.out.println("moow");
        
    }
    
}
