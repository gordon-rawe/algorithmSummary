package oddevenswap;

import lastk.LastKNode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/28.
 */
public class OddEvenSwap {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(505);
        }
        return retValue;
    }

    public static void reverseLinkedList(LastKNode.Node head) {
        if (head == null || head.next == null) return;
        LastKNode.Node current = head,aux;
        while (current.next!=null){
            aux = current.next;
            current.next = current.next.next;
            aux.next = head;
            head = aux;
        }
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static void oddEvenSwap(int[] src) {
        if (src == null || src.length == 0) return;
        int p1 = 0, p2 = src.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && isEven(src[p1])) p1++;
            while (p1 < p2 && isEven(src[p2])) p2--;
            if (p1 < p2) {
                swap(src, p1, p2);
            }
        }
    }

    public static boolean isEven(int src) {
        return (src & 1) == 0;
    }

    public static void main(String[] args) {
        int[] source = buildArrayNumbers();
        oddEvenSwap(source);
        Arrays.stream(source).forEach(value -> {
            System.out.print(value);
            System.out.print(' ');
        });
    }
}
