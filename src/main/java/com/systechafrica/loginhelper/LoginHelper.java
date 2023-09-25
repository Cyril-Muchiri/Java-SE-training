package com.systechafrica.loginhelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.systechafrica.dbconfig.DbConnector;

public class LoginHelper {
    java.sql.Statement statement;
    java.sql.CallableStatement callableStatement;
    DbConnector connector = DbConnector.createConnector();
    Connection connection = connector.getConnection();
    ResultSet resultSet;
    boolean isOwner;

    public boolean checkUserCredentials(int customerNumber, String password) {

        try {

            statement = connection.createStatement();
            callableStatement = connection.prepareCall("{CALL selectMember(?)}");
            callableStatement.setInt(1, customerNumber);
            resultSet = callableStatement.executeQuery();
        
            while (resultSet.next()) {
                int storedNumber = resultSet.getInt(1);
                String storedPassword = resultSet.getString(2);

                if (storedNumber == customerNumber && storedPassword.equals(password)) {
                    isOwner = true;

                } else {
                    isOwner = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("something went terribly wrong");
        }
        return isOwner;
    }

}
