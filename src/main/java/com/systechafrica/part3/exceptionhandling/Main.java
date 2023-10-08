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
        try {
            main.divide();
        } catch (CustomException e) {
            e.printStackTrace();
        }
       
    }
}
