package org.example.DSA_Course.Data_Structures.Queue_Dequeue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Basics {
    public static void main(String[] args) {
        // FIFO
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);           // 10 is at the front // FIRST IN
        queue.add(4);            // [10,4]
        System.out.println(queue.remove());  // prints 10 → removes front // FIRST OUT -> now [4]
        System.out.println(queue.peek());    // prints 4 → front is now 4

        //*** Metodlar FIFO-ya uymalidir -> add axira elave edirse, remove evvelden silmelidir, eksi olsa LIFO**
    }
}
