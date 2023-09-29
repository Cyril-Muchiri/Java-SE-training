package com.systechafrica.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DbConnector {
    static Dotenv dotenv = Dotenv.configure().load();

    static private String DB_URL=null;
    static private final String DB_USER = dotenv.get("DB_USER");
    static private final String DB_PASS = dotenv.get("DB_PASS");
    static private Connection connection;

    public static void setDB_URL(String dB_URL) {
        DB_URL = dB_URL;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }

    public static DbConnector createConnector() {
        DbConnector connector = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASS);
            connector = new DbConnector(connection);
            System.out.println("connected to db successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connector;
    }

    public DbConnector(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
