package com.systechafrica.part4.lambdas;

public interface LambdaDemoB {
    int sum(int a, int b, int... numbers);

    default int sum(int a, int b) {
        return a + b;
    }
}

class DemoB {

    public static void main(String[] args) {

        // ? using lambda
        System.out.println("Lambda implementation 1");
        LambdaDemoB demoB = (a, b, numbers) -> {

            int sum = a + b;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        };
        int result = demoB.sum(10, 20, 30, 40, 50, 60, 70);
        System.out.println(result);
        
        System.out.println("\nUsing default implementation");
      System.out.println(demoB.sum(10, 10));

        // LambdaDemoB demoB = new LambdaDemoB() {

        // @Override
        // public int sum(int a, int b, int... numbers) {
        // int sum = a + b;
        // for (int number : numbers) {
        // sum += number;
        // }
        // return sum;
        // }

        // };

        // System.out.println(demoB.sum(10, 15, 20,30,40,50));
    }
}
