package com.systechafrica.part3.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.CallableStatement;

import io.github.cdimascio.dotenv.Dotenv;

public class DbHelper {
    static Logger LOGGER = Logger.getLogger(DbHelper.class.getName());
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

    void dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            System.out.println("--------Database connected successfully------!!");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();

            System.out.println("Unexctpected error occured!!");
        } catch (SQLException err) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("Error connecting to database!!");
        }

    }

    boolean checkUserCredentials(int customerNumber,String password){
        
try {
  
    statement=connection.createStatement();
    callableStatement=connection.prepareCall("{CALL selectMember(?)}");
    callableStatement.setInt(1,customerNumber);
    resultSet=callableStatement.executeQuery();
    // resultSet=statement.executeQuery("CALL selectMember()");
    while(resultSet.next()){
      int  storedNumber=resultSet.getInt(1);
      String  storedPassword=resultSet.getString(2);

      if(storedNumber==customerNumber && storedPassword.equals(password)){
        isOwner=true;
        
      }else{
        isOwner=false;
        
      }
    }

} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
return isOwner;
        
    }

    static void depositFunds(String depositQuery) {
        try {

            preparedStatement = connection.prepareStatement(depositQuery);
            int noOfRows = preparedStatement.executeUpdate();
            LOGGER.info(" " + noOfRows);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("Something went terribly wrong!!");
        }
    }

    static void showTable() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM membersTable");



            while (resultSet.next()) {
                String data = resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3)
                        + " | " + resultSet.getString(4) + " | ";
                        System.out.println(data);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("unexpected error occured!!");
        }
    }
}
