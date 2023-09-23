package com.systechafrica.menu;

import java.util.Scanner;

import com.systechafrica.pos.Pos;


public class Menu {
    private Scanner menuScanner = new Scanner(System.in);
    int memCounter = 0;
    String[] selectedItems = new String[6];
    int[] itemPrices = new int[6];

    void displayMenu() {
        
        System.out.println("-----------------------------------");
        System.out.println("SYSTECH RESTRAUNT :");

        System.out.println("DRINKS");
        System.out.println("------------------");
        System.out.println("1. Chai ------------------------------ 15");
        System.out.println("2. Andazi ---------------------------- 10");
        System.out.println("3. Tosti ----------------------------- 12");

        System.out.println("");
        System.out.println("MEALS");
        System.out.println("------------------");
        System.out.println("4. Ndengu & Accomplishments ----------- 70");
        System.out.println("5. Beans & Accomplishments ------------- 70");
        System.out.println("6. Pilau veg --------------------------- 90");
        System.out.println("7. Quit");

        System.out.println(" ");
        System.out.println("Enter meal/option: ");
        int choice = menuScanner.nextInt();

        switch (choice) {
            case 1:
                memCounter += 1;
                selectedItems[memCounter] = "Chai";
                itemPrices[memCounter] = 15;
                break;
                case 2:
                memCounter += 1;
                selectedItems[memCounter] = "Andazi";
                itemPrices[memCounter] = 10;
                break;
            case 3:
                memCounter += 1;
                selectedItems[memCounter] = "Tosti";
                itemPrices[memCounter] = 12;
                break;
            case 4:
                memCounter += 1;
                selectedItems[memCounter] = "Ndengu & accomplishmemts";
                itemPrices[memCounter] = 70;
                break;
            case 5:
                memCounter += 1;
                selectedItems[memCounter] = "Beans & accomplishmemts";
                itemPrices[memCounter] = 70;
                break;
            case 6:
                memCounter += 1;
                selectedItems[memCounter] = "Pilau veg";
                itemPrices[memCounter] = 90;
                break;
            
            case 7:
                if (memCounter > 0) {
                    askForMoreItems();
                } else {
                    calculateTotal();
                }
                break;
            default:
            System.out.println("Invalid option!!");
            displayMenu();
                break;
        }
        displaySelectedItems();
        displayMenu();
    }

    void askForMoreItems() {
        System.out.print("Do you want to pick another item? (y/n): ");
        String choice = menuScanner.next().toLowerCase();
        if (choice.equals("y")) {
            displayMenu();
        } else {
            calculateTotal();
        }
    }

    void calculateTotal() {
        int total = 0;
        for (int i = 1; i <= memCounter; i++) {
            total += itemPrices[i];
        }
        System.out.println("Total to pay: " + total+" ksh");
    
        
        System.out.print("Proceed to payment? (y/n): ");
        String choice = menuScanner.next().toLowerCase();
        if (choice.equals("y")) {
            processPayment(total);
        } else {
            displayMenu();
        }
    }

    void processPayment(int total) {
        System.out.println("Pay now");
        displaySelectedItems();
        System.out.println("Total Price: " + total+ " ksh");
        
        System.out.print("Enter the amount: ");
        int amount = menuScanner.nextInt();

        if (amount >= total) {
            int balance = amount - total;
            System.out.println("Balance: " + balance+ " ksh");
        } else {
            System.out.println(" Payment failed.Insufficient Amount!!");
            System.out.println("ABORTING!!");
        }
    }

    void displaySelectedItems() {
        for (int i = 1; i <= memCounter; i++) {
            System.out.println(selectedItems[i]);
        }
    }

    public static void main(String[] args) throws InterruptedException {
       Menu menu=new Menu();
    Pos pos = new Pos();
    pos.login();
    if (pos.isLoggedIn()) {
        menu.displayMenu();
    }
    }
}

    
