package heap;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/16.
 */
public class FindMaxKPartitionAlgorithm {

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

    public static int[] findMinK(int[] array, int k) {
        int len = array.length;
        int index = partition(array, 0, len - 1);
        int[] ret = new int[k];
        int start = 0, end = len - 1;
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(array, start, end);
            } else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Arrays.stream(findMinK(new int[]{12,3,4,5,6,7,3,4}, 5)).forEach(System.out::print);
    }
}
