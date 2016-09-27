package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/27.
 */
public class BubbleSort {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(501);
        }
        return retValue;
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static void bubbleSort(int[] source) {
        int len = source.length;
        boolean flag = true;
        for (int i = 0; i < len - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (source[j] < source[j + 1]) {
                    swap(source, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = buildArrayNumbers();
        bubbleSort(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}
