package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/27.
 */
public class HeapSort {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(498);
        }
        return retValue;
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static void maxHeapify(int[] source, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int larger = index;
        if (left <= heapSize && source[larger] <= source[left]) larger = left;
        if (right <= heapSize && source[larger] <= source[right]) larger = right;
        if (larger != index) {
            swap(source, larger, index);
            maxHeapify(source, heapSize, larger);
        }
    }

    public static void buildMaxHeap(int[] source) {
        int len = source.length;
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(source, len - 1, i);
        }
    }

    public static void heapSort(int[] source) {
        buildMaxHeap(source);
        int cursor;
        cursor = source.length - 1;
        while (cursor > 0) {
            swap(source, cursor, 0);
            maxHeapify(source, --cursor, 0);
        }
    }

    public static void main(String[] args) {
        int[] list = buildArrayNumbers();
        heapSort(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}
