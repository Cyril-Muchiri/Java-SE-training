package com.systechafrica.atm;

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

    public static void main(String[] args) {
        DbHelper helper=new DbHelper();
        helper.dbConnect();
        // withdrawFunds(1, 1000);
        System.out.println(helper.getBalance(1));
      
    }

   static void closeResources(){
        try {
            statement.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

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
    System.out.println("something went terribly wrong");
}
return isOwner;
        
    }

    static void depositFunds(int memberNumber,double moneyIn) {
        try {

           statement=connection.createStatement();
           callableStatement=connection.prepareCall( "{CALL depositFunds(?,?)}");
           callableStatement.setInt(1, memberNumber);
           callableStatement.setDouble(2, moneyIn);
int noOfRows=callableStatement.executeUpdate();
           
            // int noOfRows = preparedStatement.executeUpdate();
            
            // LOGGER.info(" " + noOfRows);
            if(noOfRows!=0){
                System.out.println("Transaction successful");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("Something went terribly wrong!!");
        }
    }

    static double getBalance(int memberNumber){
        double returnedBalance=0;
try {
    
         statement=connection.createStatement();
         java.sql.CallableStatement callable=connection.prepareCall("{CALL selectMember(?)}");
    callable.setInt(1, memberNumber);
    resultSet=callable.executeQuery();
    while(resultSet.next()){
      double  balance=resultSet.getDouble(4);
      returnedBalance+=balance;
        return balance;
    }
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
return returnedBalance;


        
    }

static boolean withdrawFunds(int memberNumber,double moneyOut){
        boolean isSuccessfull=false;
try {
    
    double currentBalance;
         statement=connection.createStatement();
         java.sql.CallableStatement callable=connection.prepareCall("{CALL selectMember(?)}");
callable.setInt(1, memberNumber);
resultSet=callable.executeQuery();

// while(resultSet.next()){
//     currentBalance=resultSet.getDouble(4);
//     System.out.println(currentBalance);
// }

while (resultSet.next()) {
    currentBalance=resultSet.getDouble(4);

    if(currentBalance>moneyOut){
        isSuccessfull=true;
            callableStatement=connection.prepareCall( "{CALL withdrawFunds(?,?)}");
           callableStatement.setInt(1, memberNumber);
           callableStatement.setDouble(2, moneyOut);
int noOfRows=callableStatement.executeUpdate();


           
            // int noOfRows = preparedStatement.executeUpdate();
            
            // LOGGER.info(" " + noOfRows);
            if(noOfRows!=0){
                System.out.println("Transaction successful");
            }
    }else{
        isSuccessfull=false;
        
        System.out.println("Inadequate funds!!");
        return isSuccessfull;
    }


    return isSuccessfull;
}

       
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
// return isSuccessfull;
return isSuccessfull;


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
