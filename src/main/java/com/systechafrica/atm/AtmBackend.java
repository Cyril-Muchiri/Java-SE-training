package com.systechafrica.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import io.github.cdimascio.dotenv.Dotenv;

public class AtmBackend {
    static Logger LOGGER = Logger.getLogger(AtmBackend.class.getName());
    Dotenv dotenv = Dotenv.configure().load();

    final String DB_URL = dotenv.get("ATM_URL");
    final String DB_USER = dotenv.get("DB_USER");
    final String DB_PASS = dotenv.get("DB_PASS");
    static Connection connection;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;
    static java.sql.Statement statement;
    static boolean isOwner;
    static java.sql.CallableStatement callableStatement;

    void closeResources() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void connectDb() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void depositFunds(int memberNumber, double moneyIn) {
        try {
            AtmBackend a = new AtmBackend();
            a.connectDb();
            statement = connection.createStatement();
            callableStatement = connection.prepareCall("{CALL depositFunds(?,?)}");
            callableStatement.setInt(1, memberNumber);
            callableStatement.setDouble(2, moneyIn);
            int noOfRows = callableStatement.executeUpdate();
            if (noOfRows != 0) {
                System.out.println("Transaction successful");
            }
        } catch (SQLException e) {
            System.out.println("Something went terribly wrong!!");
            System.out.println(e);
        }
    }

    static double getBalance(int memberNumber) {
        double returnedBalance = 0;
        try {
            AtmBackend a = new AtmBackend();
            a.connectDb();
            statement = connection.createStatement();
            java.sql.CallableStatement callable = connection.prepareCall("{CALL selectMember(?)}");
            callable.setInt(1, memberNumber);
            resultSet = callable.executeQuery();
            while (resultSet.next()) {
                double balance = resultSet.getDouble(4);
                returnedBalance += balance;
                return balance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedBalance;
    }

    static boolean withdrawFunds(int memberNumber, double moneyOut) {
        boolean isSuccessfull = false;
        try {
            AtmBackend a = new AtmBackend();
            a.connectDb();
            double currentBalance;
            statement = connection.createStatement();
            java.sql.CallableStatement callable = connection.prepareCall("{CALL selectMember(?)}");
            callable.setInt(1, memberNumber);
            resultSet = callable.executeQuery();

            while (resultSet.next()) {
                currentBalance = resultSet.getDouble(4);

                if (currentBalance > moneyOut) {
                    isSuccessfull = true;
                    callableStatement = connection.prepareCall("{CALL withdrawFunds(?,?)}");
                    callableStatement.setInt(1, memberNumber);
                    callableStatement.setDouble(2, moneyOut);
                    int noOfRows = callableStatement.executeUpdate();

                    if (noOfRows != 0) {
                        System.out.println("Transaction successful");
                    }
                } else {
                    isSuccessfull = false;

                    System.out.println("Inadequate funds!!");
                    return isSuccessfull;
                }
                return isSuccessfull;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccessfull;
    }

    static void showTable() {
        try {
            AtmBackend a = new AtmBackend();
            a.connectDb();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM membersTable");

            while (resultSet.next()) {
                String data = resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3)
                        + " | " + resultSet.getString(4) + " | ";
                System.out.println(data);
            }
        } catch (SQLException e) {
            System.out.println("unexpected error occured!!");
        }
    }
}
