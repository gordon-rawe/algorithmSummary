package jowselfring;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gordon on 16/11/26.
 */
public class JowSelfRing {

    public static void main(String[] args) {
        finalRingPosition(new int[]{1, 2, 2, 3, 4}, 3);
    }

    /**
     * 约瑟夫环问题，n代表数组的长度，m代表步数
     * 函数->
     * n = 1 -> 0
     * n > 1 -> (f(n-1,m)+m)%n
     */
    public static void finalRingPosition(int[] arr, int m) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() > 1) {
            int counter = m;
            while (counter-- > 1) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
