package com.systechafrica.pos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Logger;

import com.systechafrica.dbloggers.FileLogger;

import io.github.cdimascio.dotenv.Dotenv;

public class PosBackend {
    Connection connection;
    Statement statement;
    java.sql.CallableStatement callableStatement;
    private Logger logger = FileLogger.getLogger();

    void postToDb(double transactionCost) throws SQLException {
        UUID trascationId = UUID.randomUUID();
        
        try{
            Dotenv dotenv = Dotenv.configure().load();
            connection = DriverManager.getConnection(dotenv.get("POS_URL"), dotenv.get("DB_USER"),
                    dotenv.get("DB_PASS"));
            callableStatement = connection.prepareCall("{CALL UPDATEPOSTABLE(?,?)}");
            callableStatement.setString(1, trascationId.toString());
            callableStatement.setDouble(2, transactionCost);
            int rowsAffected = callableStatement.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("post made successfully");
            } else {
                System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            System.out.println("something went wrong");
        }finally{
          callableStatement.close();
          connection.close();
        }
    }
}
