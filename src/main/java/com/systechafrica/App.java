package com.systechafrica;

import java.util.logging.Logger;

import com.systechafrica.part1.operators.Operators;
import com.systechafrica.part1.variables.Variables;


public class App
{
    private static final Logger LOGGER=Logger.getLogger(App.class.getName());

    public static void main( String[] args ) {


        Variables variables=new Variables();

        Operators operators1=new Operators();

    System.out.println(operators1.addNumbers(variables.x, variables.y,variables.z));
       System.out.println( operators1.multiplyNumbers(variables.x, variables.y,variables.z));
        System.out.println(operators1.subtractNumbers(variables.x, variables.y,variables.z));
        System.out.println(operators1.divideNumbers((double)variables.z, (double)variables.x));
        System.out.println(operators1.modulusNumbers(variables.z,variables.x));

        variables.varFunc();

        int result = addNumbers(1,2);

        LOGGER.info("result : "+result);
        System.out.println(" ");

        System.out.println("String methods start here ");

        // createString();
        // conversions();
        // stringBooleans();

        int [] numbers ={1,2,3,4,5,6,7,8};
        for (int i : numbers) {
            System.out.println(i);
        }

    }
        public static int addNumbers(int a,int b){
        return a+b;
    }

    static void createString(){
        String message ="Hello world";

        String messaeObj= new String("Coding in java");

        System.out.println("using + operator "+message + " "+messaeObj);

        System.out.println("using concat method "+messaeObj.concat(message));
    }

    static void conversions(){

       
        String message = "coding in java";

        String numberMessage ="69";

        //get string length
        System.out.println(message.length());

        //convert to uppercase
        System.out.println(message.toUpperCase());

        //trimming
        System.out.println(message.trim());
        //converting strings to other data types

        int convertedString =Integer.valueOf(numberMessage);

    String numbeString= String.valueOf(10);
System.out.println(convertedString +" "+ numbeString);

    }
    static void stringBooleans(){
        //boolean arguments for string methods
        // compare 2 strings
        String name1 = "Kinuthia";
        String name2 = "kinuthia";

       System.out.println(name1.equals(name2)); 

       //search in a string
       System.out.println(name1.contains("u"));

       //replace in a string
       String name = name1.replace('i', 'a');
       System.out.println("New name after replacement is "+ name);
    }


}
