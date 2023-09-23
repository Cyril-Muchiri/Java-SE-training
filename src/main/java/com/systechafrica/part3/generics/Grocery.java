package com.systechafrica.part3.generics;

public class Grocery {
    private double groceryQuantity;

    public double getGroceryQuantity() {
        return groceryQuantity;
    }

    public void setGroceryQuantity(double groceryQuantity) {
        this.groceryQuantity = groceryQuantity;
    }

    @Override
    public String toString() {
        return Grocery.class.getName()+"[groceryQuantity=" + groceryQuantity + "]";
    }
}
