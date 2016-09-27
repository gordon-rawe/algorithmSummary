package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 16/9/27.
 */
public class InsertSort {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(503);
        }
        return retValue;
    }

    public static void insertSort(int[] source) {
        int len = source.length;
        for (int i = 0; i < len - 1; i++) {
            if (source[i + 1] < source[i]) {
                int tmpValue = source[i + 1];
                int k = i;
                while (k >= 0 && source[k] > tmpValue) {
                    source[k + 1] = source[k];
                    k--;
                }
                source[k + 1] = tmpValue;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = buildArrayNumbers();
        insertSort(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}
