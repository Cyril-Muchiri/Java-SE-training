package com.systechafrica.atm;

import java.util.Scanner;

public class Atm extends Thread {

    static Scanner scanner = new Scanner(System.in);

    static double originalBalance = 1000;
    // static do newBalance;
    static double newWithdrawCash;
    static double withdrawCash;

    static int customerInput;
    static String suppliedPass;

    static int count = 3;


    static void startPrompts(int counter) throws InterruptedException {
        if (counter > 0) {
            System.out.println("Enter customer number : ");
            customerInput = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter customer password : ");
            suppliedPass = scanner.nextLine();

            logIn(customerInput, suppliedPass);

        } else {
            System.out.println("OOps!! Can't continue Maximum attempts reached");

        }

    }

    static void logIn(int customerNumber, String pass) throws InterruptedException {

        if (customerNumber == 10  && pass.equals("Admin123")) {

            System.out.println("LOGIN SUCCESSFULL !!");
            Thread.sleep(3000);
            
            displayMenu();
        } else {
            //count 2
            count--;
            //count 1
            // if(count !=0){
            System.out.println("");
            System.out.println("INVALID CREDENTIALS!!");
            System.out.println(count + " attempts remaining!!");
            System.out.println("TRY AGAIN!!\n");

            startPrompts(count);

            // }else{
            // System.out.println("OOps!! you are out of attempts try again in 10
            // minutes!!!");
            // }

        }

        // return count;
    }

    static void displayMenu() throws InterruptedException {
        // System.out.println("you are in the menu");

        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");

        System.out.println("ATM SERVICES");

        System.out.println("___________________________\n");

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer cash");
        System.out.println("5. Quit");

        System.out.println("___________________________");

        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                transferCash();
                break;
            case 5:
                quit();
                break;
            default:
                System.out.println("invalid menu item,reverting back to menu");
                Thread.sleep(2000);
                displayMenu();
                break;
        }

    }

    static void withdraw() throws InterruptedException {

        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");
        System.out.println("--------Cash Withdrwal--------\n");
        System.out.println("Withrawbale balance : " + originalBalance+" ksh");

        System.out.println("Enter amaount : ");

         withdrawCash = scanner.nextDouble();
         //2% ya transaction
         newWithdrawCash = (1.02 * withdrawCash);

        if (newWithdrawCash >= originalBalance) {
            System.out.println("Transaction failed due to insufficient balance!!");
            System.out.println("ABORTING!!");
            Thread.sleep(3000);
            displayMenu();
        } else {
            originalBalance -= newWithdrawCash;//balacnce left

            System.out.println("Processing withdrawal");
            System.out.println("withdrwal of ksh : "+withdrawCash+" is successfull");

            Thread.sleep(4000);
            // checkBalance();
            showReceipt();
        }

    }

    static void showReceipt() throws InterruptedException{
          System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");

        System.out.println("    Receipt\n");

        System.out.println("CONFIRMED WITHDRAWAL OF: "+withdrawCash+" ksh\n");

        System.out.println("Transaction cost: " +((float)(newWithdrawCash-withdrawCash)+" ksh")+"\n");

        System.out.println("Current balance : " + originalBalance + " ksh\n");

        Thread.sleep(4000);

        displayMenu();
    }

    static void checkBalance() throws InterruptedException {
        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");

        System.out.println("    check balance\n");

        System.out.println("Current balance : " + (float)originalBalance + " ksh \n");

        System.out.println("Reverting back to main menu");
        Thread.sleep(5000);
        displayMenu();

    }

    static void deposit() throws InterruptedException {
        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");
        System.out.println("--------Cash Deposit--------\n");

        System.out.println("Enter amaount : ");

        double deposit = scanner.nextDouble();

        originalBalance += deposit;

        System.out.println("Successfull deposit of : " + deposit + " ksh\n");

        System.out.println("Procesing Balance");
        Thread.sleep(3000);
        checkBalance();

    }

    static void transferCash() throws InterruptedException  {
        System.out.println("Service unavailable !!");
        Thread.sleep(2000);
        displayMenu();
    }

    static void quit() {

        System.out.println("Press any key to quit this session");
        String key = scanner.next();

        if (!key.isEmpty()) {
            return;
        }

    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to ATM SIMULATOR, press any key to continue");

        String cont = scanner.nextLine();

        if (!cont.isEmpty()) {
        
            startPrompts(count);

        } else {
            System.out.println("You didnt press any button to continue");
        }
    }
}
    

