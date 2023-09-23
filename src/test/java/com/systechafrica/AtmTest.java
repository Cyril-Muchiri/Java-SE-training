package com.systechafrica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.systechafrica.atm.Atm;
public class AtmTest {
    
    int count = 3;
Atm atm =new Atm();
    @Test
    void objectExists(){
Assertions.assertNotNull(atm,"should fail if object is not created and is empty");
    }

    @Test
    void ifThreadAlive(){
        
        Assertions.assertTrue(!atm.isAlive(),"Test whether the thread is alive");
    }

    @Test
    void logins(){
        
        int expectedCustomerInput = 5;
        String expectedPass = "Admin444";

        // Assertions.(atm.logIn(expectedCustomerInput, expectedPass),atm.logIn(10, "Admin123"));

    }



}



    

