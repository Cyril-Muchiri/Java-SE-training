package com.systechafrica.atm;

import java.util.Scanner;

import com.systechafrica.dbconfig.DbConnector;
import com.systechafrica.loginhelper.LoginHelper;

import io.github.cdimascio.dotenv.Dotenv;

public class Atm extends Thread {

    private static Scanner scanner = new Scanner(System.in);

    double originalBalance;
    Dotenv dotenv = Dotenv.configure().load();
    double newWithdrawCash;
    double withdrawCash;

    int customerInput;
    String suppliedPass;
    static int count = 3;

    AtmBackend backend = new AtmBackend();
    private static int currentMemberNumber;

    void startPrompts() throws InterruptedException {
        DbConnector.setDB_URL(dotenv.get("ATM_URL"));
        LoginHelper helper = new LoginHelper();
        while (count > 0) {
            System.out.println("Enter customer number : ");
            customerInput = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter customer password : ");
            suppliedPass = scanner.nextLine();
            if (helper.checkUserCredentials(customerInput, suppliedPass)) {
                currentMemberNumber = customerInput;
                displayMenu();
                count = 0;
            } else {
                count--;
                System.out.println("");
                System.out.println("INVALID CREDENTIALS!!");
                System.out.println(count + " attempts remaining!!");
                System.out.println("TRY AGAIN!!\n");
            }
        }
        System.out.println("Oops !! CAN'T CONTINUE");
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
        System.out.println("Withrawbale balance : " + backend.getBalance(currentMemberNumber) + " ksh");
        System.out.println("Enter amaount : ");
        withdrawCash = scanner.nextDouble();
        newWithdrawCash = (1.02 * withdrawCash);
        if (backend.withdrawFunds(currentMemberNumber, newWithdrawCash)) {
            System.out.println("Processing withdrawal");
            System.out.println("withdrwal of ksh : " + withdrawCash + " is successfull");
            showReceipt();
            Thread.sleep(4000);
            checkBalance();
        } else {
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
        System.out.println("Current balance : " + backend.getBalance(currentMemberNumber) + " ksh\n");
        Thread.sleep(4000);
        displayMenu();
    }

    void checkBalance() throws InterruptedException {
        System.out.println("\n***********************");
        System.out.println("ATM SIMULATOR");
        System.out.println("**********************");
        System.out.println("    check balance\n");
        System.out.println("Current balance : " + AtmBackend.getBalance(currentMemberNumber) + " ksh \n");
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
        backend.depositFunds(currentMemberNumber, deposit);
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
        Atm atmobj = new Atm();
        System.out.println("Welcome to ATM SIMULATOR, press any key to continue");
        String cont = scanner.nextLine();
        if (!cont.isEmpty()) {
            atmobj.startPrompts();
        }
    }
}
