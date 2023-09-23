package com.systechafrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AppTest {

    private final Logger LOGGER =Logger.getLogger(AppTest.class.getName());
    //AAA
   
    static int counter = 0;
    // instantiate Main class
    static App app;

    @BeforeEach
    void initEach() {
        app = new App();
        System.out.println("Create an instance of the main class before each test first");
    }


    // @AfterEach
    // static int countTests(){
    // return counter ++;
    // }

    @Test
    void add() {

       

        // when
        int result = app.addNumbers(10, 12);
        // then
        int expectedResult = 22;

        // verify
        Assertions.assertEquals(expectedResult, result, "The expected result of 10+12 is" + expectedResult);
    }


    @Test
    @Disabled("this test case is skippped")
    void skipTest() {
        System.out.println("This is a skipped test ,should not execute");
    }

    @Test
    void validDataType() {
        Integer result = app.addNumbers(10, 12);

        Integer expectedResult = 22;
        Assertions.assertTrue(result instanceof Integer, "The expected value is not of type Integer");
        Assertions.assertTimeout(Duration.ofMillis(50), () -> {

            int result1 = app.addNumbers(1000, 1000);
            Assertions.assertEquals(result1, 2000);

        });
    }

    @Test
    void abortedTest() {
        assumeTrue(app != null);
        // fail("test should have been aborted");
        int result = app.addNumbers(10, 10);
    

        assertEquals(20,result,"This test should have been aborted");

       
    }

    // only test allowed to fail

    // @Test
    // void failingTest() {
    //     fail("This test must fail");
    // }

    @Test
    @AfterAll
    static void completeTesting() {
        System.out.println(".....Test suite complete......");
    }

    public static void main(String[] args) {
        // System.out.println("All "+countTests()+" have been executed !!");
    }
}
