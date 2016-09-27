package sorts;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gordon on 9/27/16.
 */
public class ShellSort {
    public static int[] buildArrayNumbers() {
        Random random = new Random();
        int length = 50 + random.nextInt(50);
        int[] retValue = new int[length];
        for (int i = 0; i < length; i++) {
            retValue[i] = random.nextInt(497);
        }
        return retValue;
    }

    public static void shellSort(int[] source) {
        int length = source.length;
        int increment = length / 2;
        while (increment >= 1) {
            for (int i = increment; i < length; i++) {
                int j = i - increment;
                int key = source[i];
                while (j >= 0 && source[j] > key) {
                    source[j + increment] = source[j];
                    j = j - increment;
                }
                source[j + increment] = key;
            }
            increment /= 2;
        }
    }

    public static void shellSort1(int[] source) {
        int len = source.length;
        for (int gap = len / 2; gap >= 1; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < len; j += gap) {
                    if (source[j] < source[j - gap]) {
                        int tmpValue = source[j];
                        int k = j - gap;
                        while (k >= 0 && source[k] > tmpValue) {
                            source[k + gap] = source[k];
                            k -= gap;
                        }
                        source[k + gap] = tmpValue;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = buildArrayNumbers();
        shellSort1(list);
        Arrays.stream(list).forEach(System.out::println);
    }
}
