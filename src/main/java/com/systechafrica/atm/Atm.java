package com.systechafrica.atm;

import java.util.Scanner;

public class Atm extends Thread {

    private static Scanner scanner = new Scanner(System.in);

     double originalBalance;
    // static do newBalance;
     double newWithdrawCash;
     double withdrawCash;

     int customerInput;
     String suppliedPass;

     static int count=3;

     DbHelper helper = new DbHelper();
    private static int currentMemberNumber;

     void startPrompts(int counter) throws InterruptedException {
        helper.dbConnect();
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

     void logIn(int customerNumber, String pass) throws InterruptedException {
        if (helper.checkUserCredentials(customerNumber, pass)) {
            currentMemberNumber = customerNumber;
            System.out.println("LOGIN SUCCESSFULL !!");
            Thread.sleep(3000);

            displayMenu();
        } else {
            count--;
            System.out.println("");
            System.out.println("INVALID CREDENTIALS!!");
            System.out.println(count + " attempts remaining!!");
            System.out.println("TRY AGAIN!!\n");

            startPrompts(count);

        }

    }

     void displayMenu() throws InterruptedException {
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

     void withdraw() throws InterruptedException {

        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");
        System.out.println("--------Cash Withdrwal--------\n");

        System.out.println("Withrawbale balance : " + helper.getBalance(currentMemberNumber) + " ksh");

        System.out.println("Enter amaount : ");

        withdrawCash = scanner.nextDouble();
        // 2% ya transaction
        newWithdrawCash = (1.02 * withdrawCash);
        if (helper.withdrawFunds(currentMemberNumber, newWithdrawCash)) {
            System.out.println("Processing withdrawal");
            System.out.println("withdrwal of ksh : " + withdrawCash + " is successfull");
            showReceipt();
            Thread.sleep(4000);
            checkBalance();
            
        }

        else {
            System.out.println("could not Process transacation");

        }

    }

     void showReceipt() throws InterruptedException {
        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");

        System.out.println("    Receipt\n");

        System.out.println("CONFIRMED WITHDRAWAL OF: " + withdrawCash + " ksh\n");

        System.out.println("Transaction cost: " + ((float) (newWithdrawCash - withdrawCash) + " ksh") + "\n");

        System.out.println("Current balance : " + helper.getBalance(currentMemberNumber) + " ksh\n");

        Thread.sleep(4000);

        displayMenu();
    }

     void checkBalance() throws InterruptedException {
        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");

        System.out.println("    check balance\n");

        System.out.println("Current balance : " + helper.getBalance(currentMemberNumber) + " ksh \n");

        System.out.println("Reverting back to main menu");
        Thread.sleep(5000);
        displayMenu();

    }

     void deposit() throws InterruptedException {
        System.out.println("\n***********************");

        System.out.println("ATM SIMULATOR");

        System.out.println("**********************");
        System.out.println("--------Cash Deposit--------\n");

        System.out.println("Enter amaount : ");

        double deposit = scanner.nextDouble();

        // originalBalance += deposit;
        helper.depositFunds(currentMemberNumber, deposit);

        System.out.println("Successfull deposit of : " + deposit + " ksh\n");

        System.out.println("Procesing Balance");
        Thread.sleep(3000);
        checkBalance();

    }

     void transferCash() throws InterruptedException {
        System.out.println("Service unavailable !!");
        Thread.sleep(2000);
        displayMenu();
    }

     void quit() {

        System.out.println("Press any key to quit this session");
        String key = scanner.next();

        if (!key.isEmpty()) {
            System.exit(0);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Atm atmobj=new Atm();

        System.out.println("Welcome to ATM SIMULATOR, press any key to continue");

        String cont = scanner.nextLine();

        if (!cont.isEmpty()) {

           atmobj. startPrompts(count);

        }
    }
}
