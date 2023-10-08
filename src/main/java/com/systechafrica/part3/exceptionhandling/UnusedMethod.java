package com.systechafrica.part3.exceptionhandling;

public class UnusedMethod {
    public void sum(int a , int b, int...numbers) throws CustomException{
        throw new CustomException("This method has not been implemented");
    }
}
