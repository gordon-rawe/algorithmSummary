package checkmorethanhalf;

import java.util.TreeSet;

/**
 * Created by gordon on 16/9/29.
 */
public class CheckMoreThanHalf {

    public static int[] generateArray() {
        return new int[]{1, 2, 3, 2, 2, 2, 5, 4, 3, 3, 3, 3, 3, 3, 3, 3, 2};
    }

    public static void partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] > pivot) high--;
            swap(array, low, high);
            while (low < high && array[low] < pivot) low++;
            swap(array, low, high);
        }
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static int calcNumberMoreThanHalf(int[] array) {
        if (array == null || array.length == 0) return -1;
        partition(array, 0, array.length - 1);
        return array[array.length / 2];
    }

    public static void main(String[] args) {
        int[] source = generateArray();
        System.out.println(calcNumberMoreThanHalf(source));
    }
}
