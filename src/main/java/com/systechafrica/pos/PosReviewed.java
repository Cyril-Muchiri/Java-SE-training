package com.systechafrica.pos;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.systechafrica.customexceptions.InvalidInputException;
import com.systechafrica.dbconfig.DbConnector;
import com.systechafrica.dbloggers.FileLogger;
import com.systechafrica.loginhelper.LoginHelper;
import io.github.cdimascio.dotenv.Dotenv;

public class PosReviewed {
    Dotenv dotenv = Dotenv.configure().load();
    private Scanner posScanner = new Scanner(System.in);
    private Logger logger = FileLogger.getLogger();
    String suppliedPwd;
    boolean isLoggedIn;
    Double customerAmount = 0.0;
    double finalTotals = 0;

    Item itemObj = new Item();
    private int userItemCode[] = new int[itemObj.mem];
    private double userItemPrice[] = new double[itemObj.mem];
    private double userItemQuantity[] = new double[itemObj.mem];

    boolean login() {
        DbConnector.setDB_URL(dotenv.get("POS_URL"));
        LoginHelper login = new LoginHelper();
        int attepmts = 3;
        while (attepmts != 0) {
            System.out.println("Enter Password: ");
            suppliedPwd = posScanner.nextLine();
            if (login.checkUserCredentials(suppliedPwd)) {
                logger.info("Db login successfull");
                isLoggedIn = true;
                attepmts = 0;
            } else {
                logger.warning("Db login Attempt failed!!");
                attepmts--;
                System.out.println("INVALID CREDENTIALS ,PLEASE TRY AGAIN!!! ");
                System.out.println(attepmts + " attempts remaining!!\n");
                isLoggedIn = false;
                continue;
            }
        }
        return isLoggedIn;
    }

    void displayMenu() {

        System.out.println("------------------------------------------");
        System.out.println("         Systech POS System");
        System.out.println("------------------------------------------");
        System.out.println("1.ADD ITEM\n");
        System.out.println("2.MAKE PAYMENT\n");
        System.out.println("3.DISPLAY RECEIPT\n");
        System.out.println("4.Quit\n");
        System.out.println("------------------------------------------");
        System.out.print("choose your option : ");
        try {

            if (!posScanner.hasNextInt()) {
                posScanner.next();
                throw new InvalidInputException("Invalid input type. Please enter a valid choice.");
            }
            int choice = posScanner.nextInt();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    showReceipt(customerAmount, finalTotals);
                    break;
                case 4:
                    logger.info("user disconnected from db!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option!!,please try again!!");
                    displayMenu();
            }
        } catch (InvalidInputException e) {
            logger.warning(e.getMessage());
            displayMenu();
        }
    }

    private void addItem() {
        try {
            for (int i = 0; i <= itemObj.mem; i++) {
                System.out.print("Enter item code: ");
                if (!posScanner.hasNextInt()) {
                    throw new InvalidInputException("input ivalid:enter a valid item code-must be anumber");
                } else {
                    userItemCode[i] = posScanner.nextInt();
                }

                System.out.print("Enter item price: ");
                if (!posScanner.hasNextDouble()) {
                    throw new InvalidInputException("input ivalid:enter a valid number for the price");
                } else {
                    userItemPrice[i] = posScanner.nextDouble();
                }

                System.out.print("Enter item quantity: ");
                if (!posScanner.hasNextDouble()) {
                    throw new InputMismatchException("input ivalid:Enter a valid number for quantity");
                }
                userItemQuantity[i] = posScanner.nextDouble();
                posScanner.nextLine();
                System.out.println("Press 'A' to add more items 'N' to g back to main Menu");

                if (posScanner.hasNextDouble()) {
                    throw new InvalidInputException("invalid choice please try again!!");
                } else {
                    String choice = posScanner.nextLine().toUpperCase();

                    switch (choice) {
                        case "A":
                            break;
                        case "N":
                            i = itemObj.mem;
                            displayMenu();
                            break;
                    }
                }
            }

        } catch (InvalidInputException err) {
            logger.warning(err.getMessage());
            displayMenu();
        }
    }

    private void makePayment() {
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Item code", "Quantity", "Unit Price", "Total Value");
        double finalTotals = 0;
        double totalPrice;
        PosBackend backend = new PosBackend();
        for (int i = 0; i < itemObj.mem; i++) {
            if (userItemCode[i] != 0) {
                totalPrice = userItemQuantity[i] * userItemPrice[i];
                System.out.printf("%-15s%-15s%-15s%-15s\n", userItemCode[i], userItemQuantity[i], userItemPrice[i],
                        totalPrice);
                finalTotals += totalPrice;
            }
        }
        try {

            System.out.println("*****************************************************");
            System.out.println("TOTAL   - " + finalTotals + " ksh");
            System.out.println("******************************************");

            if (finalTotals == 0) {
                System.out.println("Nothing to display here!!");
                displayMenu();
            } else {
                System.out.print("Enter amount by customer: ");
                if (!posScanner.hasNextInt()) {
                    throw new InvalidInputException("invalid number entered!please enter a number!!");
                } else {
                    customerAmount = posScanner.nextDouble();
                    if (customerAmount < finalTotals) {
                        System.out.println("cannot process payment insuficient funds!!!");
                    } else {
                        showReceipt(customerAmount, finalTotals);
                        backend.postToDb(finalTotals);
                    }
                }
            }

        } catch (SQLException | InvalidInputException err) {
            logger.warning(err.getMessage());
        }
    }

    void showReceipt(double customerAmount, double finalTotals) {
        if (finalTotals == 0) {
            System.out.println("No receipt available");
            System.out.println("Add items to cart");
            displayMenu();
        } else {
            System.out.println("Change  - " + (customerAmount - finalTotals) + " ksh");
            System.out.println("******************************************");
            System.out.println("THANK YOU FOR SHOPPING WITH US");
            System.out.println("******************************************");
            posScanner.close();

        }

    }

    public static void main(String[] args) {
        PosReviewed pos = new PosReviewed();
        // pos.login();
        if (pos.login()) {
            pos.displayMenu();
        } else {
            System.out.println("CAN'T CONTINUE TOO MANY FAILED ATTEMPTS !!");
        }
    }
}