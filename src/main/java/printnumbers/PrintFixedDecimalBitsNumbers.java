package printnumbers;

/**
 * Created by gordon on 9/28/16.
 */
public class PrintFixedDecimalBitsNumbers {
    public static void printDecimalBitsNumbers(int n) {
        int[] array = new int[n];
        cursiveTraverse(array, n, 0);
    }

    private static void cursiveTraverse(int[] src, int length, int index) {
        if (index == length) {
            print(src);
            return;
        }
        for (int i = 0; i < 10; i++) {
            src[index] = 48 + i;
            cursiveTraverse(src, length, index + 1);
        }
    }

    private static void print(int[] src) {
        for (int i = 0; i < src.length; i++) {
            System.out.print((char) src[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printDecimalBitsNumbers(3);
    }
}
