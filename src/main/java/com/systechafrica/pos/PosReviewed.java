package com.systechafrica.pos;

import java.sql.Connection;

import com.systechafrica.DbConnector;

import io.github.cdimascio.dotenv.Dotenv;

public class PosReviewed {
    
    public static void main(String[] args) {
      DbConnector connector=DbConnector.createConnector();
      Connection connection=connector.getConnection();
    }
    
}
