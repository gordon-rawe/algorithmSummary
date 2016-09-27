package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/27.
 */
public class MergeSort {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(504);
        }
        return retValue;
    }

    public static void mergeSort(int[] source) {
        int len = source.length;
        sort(source, 0, len - 1);
    }

    public static void sort(int[] src, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(src, low, mid);
            sort(src, mid + 1, high);
            merge(src, low, mid, high);
        }
    }

    public static void merge(int[] src, int low, int mid, int high) {
        int[] tmpArray = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            tmpArray[k++] = src[i] > src[j] ? src[i++] : src[j++];
        }
        while (i <= mid) tmpArray[k++] = src[i++];
        while (j <= high) tmpArray[k++] = src[j++];
        for (int l = 0; l < tmpArray.length; l++) {
            src[l + low] = tmpArray[l];
        }
    }

    public static void main(String[] args) {
        int[] list = buildArrayNumbers();
        mergeSort(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}
