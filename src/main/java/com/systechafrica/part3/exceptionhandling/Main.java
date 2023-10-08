package com.systechafrica.part3.exceptionhandling;

public class Main {
    void divide() throws CustomException {
        int a = 10;
        int b = 0;
        Double result = (double) a / b;
        if (result.isNaN()) {
            throw new CustomException("operation illegal");
        } else {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        UnusedMethod md=new UnusedMethod();

        try {
            main.divide();
            md.sum(10, 12,13,14 ,15);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
       
    }
}
