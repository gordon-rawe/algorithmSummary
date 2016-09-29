package fullrange;

/**
 * Created by gordon on 16/9/29.
 */
public class PrintOneToNBitNumbers {

    public static final int zero = 48;

    public static void printOneToN(int n) {
        if (n <= 0) return;

        int[] array = new int[n];
        recurse(array, n, -1);
    }

    public static void recurse(int[] array, int length, int index) {
        if (index == length - 1) {
            printArray(array);
            return;
        }
        for (int i = 0; i < 10; i++) {
            array[index + 1] = zero + i;
            recurse(array, length, index + 1);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((char) array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printOneToN(4);
    }
}
