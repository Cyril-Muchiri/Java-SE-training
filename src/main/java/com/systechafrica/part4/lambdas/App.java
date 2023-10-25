package com.systechafrica.part4.lambdas;

@FunctionalInterface
interface App {
    void show(int i);
}

 class A {

    // implementing a functional interface which contains 1 abstract method
    public static void main(String[] args) {

// App obj = new App() {

//     @Override
//     public void show(int i) {
//        System.out.println( "In the show "+i);
//     }
    
// };
        
        App obj = i->System.out.println("In the show method "+i);
        obj.show(10);
        
        
    }

}
