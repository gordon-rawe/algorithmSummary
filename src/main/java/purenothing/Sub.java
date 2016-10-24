package purenothing;

import java.util.*;

/**
 * Created by gordon on 16/10/15.
 */
public class Sub extends Super {
    public static void main(String[] args) {
        Queue<Integer> integerPriorityQueue = new ArrayDeque<>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing Integer:"+in);
        }
    }
}
