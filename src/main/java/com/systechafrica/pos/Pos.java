package com.systechafrica.pos;

import java.util.Scanner;

public class Pos {
    private Scanner posScanner = new Scanner(System.in);
    Items itemsObj = new Items();
    final int MAXCART = 5;
    int mem = MAXCART;
    private boolean isLoggedIn;

    int[] itemCodes = new int[mem];
    int[] itemPrice = new int[mem];
    int[] itemQuantity = new int[mem];

    int finalTotals = 0;

    String[] cartItems = new String[mem];

    public void login() throws InterruptedException {
        int count = 3;
        final String DEFAULTPASS = "Admin123";

        while (count > 0) {
            System.out.print("Enter user password:");
            String suppliedPass = posScanner.next();

            if (suppliedPass.equals(DEFAULTPASS)) {
                System.out.println(" LOGIN SUCCESSFULL!! ");
                Thread.sleep(3000);
                isLoggedIn = true;
                return;
            } else {
                count--;
                System.out.println("INVALID CREDENTIALS ,PLEASE TRY AGAIN!!! ");
                System.out.println(count + " attempts remaining!!\n");
            }
        }
        System.out.println("OOPS YOU RAN OUT OF TRIALS!!\n");

    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    void addItem() throws InterruptedException {
        posScanner.nextLine();

        for (int i = 0; i < mem; i++) {

            System.out.println("Enter item name: ");
            itemsObj.userItems[i] = posScanner.nextLine();

            cartItems[i] = itemsObj.userItems[i];
            System.out.println("Press A to add more items, V to view cart, N to proceed to main menu");
            String choice = posScanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    break;
                case "V":
                    displayCartItems();
                    break;
                case "N":
                    displayMenu();
                    return; // Exit the method since the user wants to proceed to the main menu
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }

        }
        System.out.println("You maxed your cart out ,proceeding to main menu");
        Thread.sleep(2000);
        displayMenu();
    }

    void displayCartItems() throws InterruptedException {
        for (String item : cartItems) {
            int i = 0;
            System.out.println(item);
            i++;
        }
        Thread.sleep(3000);
        displayMenu();

    }

    void cashier() {
        for (int i = 0; i < cartItems.length; i++) {

            if (cartItems[i] != null) {
                System.out.println("Complete checkout for " + cartItems[i]);
                System.out.print("item code: ");

                itemCodes[i] = posScanner.nextInt();

                posScanner.nextLine();

                System.out.print("item quantity: ");

                itemQuantity[i] = posScanner.nextInt();
                posScanner.nextLine();

                System.out.print("item price: ");
                itemPrice[i] = posScanner.nextInt();
            } else {
                itemCodes[i] = 0;
                posScanner.nextLine();
                itemQuantity[i] = 0;
                posScanner.nextLine();
                itemPrice[i] = 0;
            }

        }
        displayCheckOut();
    }

    void displayCheckOut() {
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Item code", "Quantity", "Unit Price", "Total Value");

        int totalPrice;
        int customerAmount;

        for (int i = 0; i < cartItems.length; i++) {
            totalPrice = itemQuantity[i] * itemPrice[i];
            System.out.printf("%-15s%-15s%-15s%-15s\n", itemCodes[i], itemQuantity[i], itemPrice[i], totalPrice);

            finalTotals += totalPrice;

        }
        System.out.println("*****************************************************");
        System.out.println("TOTAL   - " + finalTotals + " ksh");
        System.out.println("******************************************");

        System.out.print("Enter amount by customer: ");
        customerAmount = posScanner.nextInt();

        if (customerAmount >= finalTotals) {
            System.out.println("Change  - " + (customerAmount - finalTotals) + " ksh");
            System.out.println("******************************************");
            System.out.println("THANK YOU FOR SHOPPING WITH US");
            System.out.println("******************************************");
        } else {
            System.out.println("cannot process payment insuficient funds!!!");
        }
    }

    void displayMenu() throws InterruptedException {

        System.out.println("------------------------------------------");
        System.out.println("         Systech POS System");
        System.out.println("------------------------------------------");
        System.out.println("1.ADD ITEM\n");
        System.out.println("2.MAKE PAYMENT\n");
        System.out.println("3.DISPLAY RECEIPT\n");
        System.out.println("------------------------------------------");
        System.out.print("choose your option : ");

        int choice = posScanner.nextInt();

        switch (choice) {
            case 1:
                addItem();
                break;

            case 2:
                cashier();

                break;

            case 3:
                break;

            default:
                System.out.println("Invalid option!!,please try again!!");
                Thread.sleep(3000);
                displayMenu();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Pos p = new Pos();
        p.login();
        if (p.isLoggedIn) {
            p.displayMenu();
        }

    }
}