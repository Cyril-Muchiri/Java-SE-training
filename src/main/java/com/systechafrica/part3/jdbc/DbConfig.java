package com.systechafrica.part3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DbConfig {
    Dotenv dotenv=Dotenv.configure().load();
    
 final String DB_URL=dotenv.get("ATM_URL");
 final String DB_USER=dotenv.get("DB_USER");
 final String DB_PASS=dotenv.get("DB_PASS");

void dbConnect(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect =DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        
        if(connect!=null){
            System.out.println("--------Database connected successfully------!!");
        }else{
            System.out.println("Database not connected succsfully");
        }

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();

        System.out.println("Unexctpected error occured!!");
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        // e.printStackTrace();
        System.out.println("Error connecting to database!!");
    }
}

}
