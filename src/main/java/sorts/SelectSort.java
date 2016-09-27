package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/27.
 */
public class SelectSort {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(502);
        }
        return retValue;
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static void selectSort(int[] source) {
        int len = source.length;
        for (int i = len - 1; i > 0; i--) {
            int _min = 0;
            for (int j = 0; j < i - 1; j++) {
                if (source[j] < source[_min]) _min = j;
            }
            swap(source, _min, i);
        }
    }

    public static void main(String[] args) {
        int[] list = buildArrayNumbers();
        selectSort(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}
