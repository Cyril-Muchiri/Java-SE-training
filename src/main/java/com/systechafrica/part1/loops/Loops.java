package com.systechafrica.part1.loops;

public class Loops {
    // switch , for ,while , dowhile

    //prints numbers from 0-range specified (For loop)
    public void printNumbers(int range){
    
        for(int i =0; i <= range;i++){
            System.out.println(i);
        }
    }

//prints a pattern while the condition specified is still true
public void printPattern(int range){
int i =0;
while(i<range){
    for(i=0;i<range;i++){
    System.out.println("*");
    }i++;
}
}

//prints a first statement then continues
public void printFirstTenNumbers(){
    int i=0;
do {
    System.out.println("This prints first 10 numbers of a sequence");
    i++;
} while(i<10);
System.out.println(i);




}

//prints name of the day of the week (starts from 1-sunday)
public void daysOfWeek(int day){
    // while(day<8){

 switch(day){
    case 1:System.out.println("Its a bright Sunday Morning, Go to church");
    break;
    case 2:System.out.println("Its a bright Monday Morning, Go to WORK!!");
    break;
    case 3:System.out.println("Its a bright Tuesday Morning, Go to WORK");
    break;
    case 4:System.out.println("Its a bright Wednesday Morning, Go to WORK");
    break;
    case 5:System.out.println("Its a bright Thursday Morning, Go to WORK");
    break;
    case 6:System.out.println("Its a feel good Friday , Go out!!");
    break;
    case 7:System.out.println("Its a wonderful Saturday afernoon, Watch Arsenal game");
    break;

    default:System.out.println("Invalid day of the week");

 }
 
}


public static void main(String[] args) {
    Loops loops = new Loops();

    loops.daysOfWeek(0);
    loops.printNumbers(20);
    loops.printFirstTenNumbers();
}
}

