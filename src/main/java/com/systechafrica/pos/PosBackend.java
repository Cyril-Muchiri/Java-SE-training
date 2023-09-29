package com.systechafrica.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Logger;

import com.systechafrica.dbconfig.DbConnector;
import com.systechafrica.dbloggers.FileLogger;

import io.github.cdimascio.dotenv.Dotenv;

public class PosBackend {
    java.sql.CallableStatement callableStatement;
    private Logger logger = FileLogger.getLogger();
    Dotenv dotenv=Dotenv.configure().load();

    void postToDb(double transactionCost) throws SQLException {
        UUID trascationId = UUID.randomUUID();
        
        try{
            DbConnector.setDB_URL(dotenv.get("POS_URL"));
            callableStatement = DbConnector.createConnector().getConnection().prepareCall("{CALL UPDATEPOSTABLE(?,?)}");
            callableStatement.setString(1, trascationId.toString());
            callableStatement.setDouble(2, transactionCost);
            int rowsAffected = callableStatement.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Transaction made successfully");
                logger.info("Transaction made in the database successfully");
            } else {
                System.out.println("something went wrong");
                logger.info("Transaction failed!!");
            }

        } catch (SQLException e) {
            System.out.println("something went wrong");
        }finally{
          callableStatement.close();
          DbConnector.closeConnection();
        }
    }
}
