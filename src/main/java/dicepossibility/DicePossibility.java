package dicepossibility;

/**
 * Created by gordon on 16/12/23.
 */
public class DicePossibility {

    public static int MAX_SIDES = 6;

    public static void printPossibility(int size) {
        if (size < 1) return;
        int max = MAX_SIDES * size;
        int len = max - size + 1;
        int[] possibilities = new int[len];
        for (int i = 0; i < possibilities.length; i++) {
            possibilities[i] = 0;
        }
        helper(size, possibilities);
        double total = Math.pow(MAX_SIDES, size);
        for (int i = size; i <= max; i++) {
            System.out.println(i + " -> " + possibilities[i - size] / total);
        }
    }

    public static void helper(int size, int[] possibilities) {
        for (int i = 1; i <= MAX_SIDES; i++) {
            helperCore(size, size, i, possibilities);
        }
    }

    public static void helperCore(int size, int current, int sum, int[] possibilities) {
        if (current == 1) {
            possibilities[sum - size]++;
        } else {
            for (int i = 1; i <= MAX_SIDES; i++) {
                helperCore(size, current - 1, sum + i, possibilities);
            }
        }
    }

    public static void main(String[] args) {
        printPossibility(6);
    }
}
