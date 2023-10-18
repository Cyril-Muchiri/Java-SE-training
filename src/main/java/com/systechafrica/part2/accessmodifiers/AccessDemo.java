package com.systechafrica.part2.accessmodifiers;

import com.systechafrica.part2.protectedpackage.Protect;

public class AccessDemo extends Protect {
    void access(){
        int b=super.a;
        int c=this.a;
    }
public static void main(String[] args) {
AccessDemo aDemo= new AccessDemo();
int a=aDemo.a;
}

}
