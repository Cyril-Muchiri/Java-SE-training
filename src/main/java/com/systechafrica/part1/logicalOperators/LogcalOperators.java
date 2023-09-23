package com.systechafrica.part1.logicalOperators;

public class LogcalOperators {

    // ==, !=, ===, >=, <= && ||
    
char gender;


String maleProNoun ="He";
String feMaleProNoun ="She";

public static boolean isWorking =true;

int age ;

String name;

public  void sayHi( char gender){
    if (gender == 'M'){
        name ="George";
        age = 21;
        System.out.println("Meet "+name + " ,"+ maleProNoun + " is "+ age + "years old");
    }else if( gender == 'F'){
name ="Mercy";
        age = 15;
        System.out.println("Meet "+name + " ,"+ feMaleProNoun + " is "+ age + "years old");
    }else{
        System.out.println("Invalid gender !!");
    }
}

public  void whoIsWorking( char gender,boolean employement){
 if (gender == 'M' && employement){
        name ="George";
        age = 21;
        System.out.println("Meet "+name + " ,"+ maleProNoun + "is "+ age + "years old and is working");
    }else if (gender == 'M' && !employement ) {
          name ="George";
        age = 21;
        System.out.println("Meet "+name + " ,"+ maleProNoun + "is "+ age + "years old and is not working");
    }
    
    
    else if( gender == 'F' || !employement){
name ="Mercy";
        age = 15;
        System.out.println("Meet "+name + " ,"+ feMaleProNoun + " is "+ age + "years old regardless if she is working she has money");
    }else{
        System.out.println("Invalid gender !!");
    }
}

public  void whoIsOlder(int age1, int age2){
   if(age1 >age2){
    System.out.println("George is older than Mercy by " + (age1-age2)+ " years old");
   }
   else if(age1 == age2){
    System.out.println("They are agemates");
   }else if(age1 <age2){
    System.out.println("Mercy is older than George by "+(age2-age1)+ " years old");
   }else{
    System.out.println("We can't really tell whose older between the two");
   }


}




public static void main(String[] args) {
    LogcalOperators loApp =new LogcalOperators();

    //expects 'F' or 'M'
    loApp.sayHi('L');

    //expects 'F' or "M" and employement
    loApp.whoIsWorking('L', isWorking);

    //expects age
    //age1 blongs to George and age2 belongs to Mercy
   loApp.whoIsOlder(56, 40);
}
}
