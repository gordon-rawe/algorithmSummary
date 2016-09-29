package heap;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/16.
 */
public class FindMaxKPartitionAlgorithm {

    public static int[] generateRandomNumbers() {
        Random seed = new Random();
        int[] retValue = new int[seed.nextInt(100)];
        for (int i = 0; i < retValue.length; i++) {
            retValue[i] = seed.nextInt(1000);
        }
        return retValue;
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] > pivot) high--;
            swap(array, low, high);
            while (low < high && array[low] < pivot) low++;
            swap(array, low, high);
        }
        return low;
    }

    public static int[] findMinK(int[] array, int n) {
        int index = partition(array, 0, n - 1);
        int[] ret = new int[n];
        int start = 0, end = n - 1;
        while (index != n - 1) {
            if (index > n - 1) {
                end = index - 1;
                index = partition(array, start, end);
            } else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }
        for (int i = 0; i < n; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Arrays.stream(findMinK(new int[]{12,3,4,5,6,7,3,4}, 5)).forEach(System.out::print);
    }
}
