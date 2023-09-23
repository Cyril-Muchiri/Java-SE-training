package com.systechafrica.part1.variables;

public class Variables {
//reusable variables
 public int x = 2;
public int y = 3;
public int z =5;
    
   public static int varFunc(){


        int a;
    double b= 10.4;

    String message;
    char choice = 'n';

    boolean isRight = true;

    if(isRight && choice=='y'){

        a=(int)b;
        System.out.println(a);

        message = "Hi ,How are you doing";

         System.out.println(message);
        
    }else{
        message =" Something is wrong";

        System.out.println(message);
        
    }
    return 0;

   
    }


public static void main(String[] args) {
    varFunc();
}

}
