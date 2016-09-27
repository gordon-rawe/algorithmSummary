package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 9/27/16.
 */
public class QuickSort {

    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(500);
        }
        return retValue;
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static int partition(int[] source, int low, int high) {
        int value = source[low];
        while (low < high) {
            while (low < high && source[high] >= value) high--;
            swap(source, low, high);
            while (low < high && source[low] <= value) low++;
            swap(source, low, high);
        }
        return low;
    }

    public static void quickSort(int[] source, int low, int high) {
        if (low < high) {
            int pivot = partition(source, low, high);
            quickSort(source, low, pivot - 1);
            quickSort(source, pivot + 1, high);
        }
    }

//
//    public static int partition(int[] src, int low, int high) {
//        int value = src[low];
//        while (low < high) {
//            while (low < high && src[high] >= value) high--;
//            swap(src, low, high);
//            while (src[low] < value && low < high) low++;
//            swap(src, low, high);
//        }
//        return low;
//    }
//
//    public static void quickSort(int[] source, int low, int high) {
//        if (low < high) {
//            int pivot = partition(source, low, high);
//            quickSort(source, low, pivot - 1);
//            quickSort(source, pivot + 1, high);
//        }
//    }


    public static void main(String[] args) {
        int[] source = buildArrayNumbers();
        quickSort(source, 0, source.length - 1);
        Arrays.stream(source).forEach(System.out::println);
    }
}