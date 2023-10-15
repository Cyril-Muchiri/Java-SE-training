package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        //!Implements a fifo approach
        Queue<String> pizaaQueue=new LinkedList<>();

        pizaaQueue.add("barbeque");//returns a boolean
        pizaaQueue.offer("Barbeque");
        pizaaQueue.offer("Chicken");
        pizaaQueue.offer("flaming cheese");

        System.out.println(pizaaQueue.remove());
        System.out.println(pizaaQueue);
    }
}
