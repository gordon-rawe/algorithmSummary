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

    public static void printPossibilities(int size) {
        if (size < 1) return;
        int[][] possibilities = new int[][]{new int[size * MAX_SIDES + 1], new int[size * MAX_SIDES + 1]};
        for (int i = 0; i < size * MAX_SIDES + 1; i++) {
            possibilities[0][i] = 0;
            possibilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i <= MAX_SIDES; i++) {
            possibilities[flag][i] = 1;
        }
        for (int curSize = 2; curSize <= size; curSize++) {
            for (int i = 0; i < curSize; i++) {
                possibilities[1 - flag][i] = 0;
            }
            for (int i = curSize; i <= MAX_SIDES * curSize; i++) {
                possibilities[1 - flag][i] = 0;
                for (int k = 1; k <= i && k <= MAX_SIDES; k++) {
                    possibilities[1 - flag][i] += possibilities[flag][i - k];
                    System.out.println("---");
                    for (int j = 0; j < possibilities[flag].length; j++) {
                        System.out.print(possibilities[flag][j] + "\t");
                    }
                    System.out.println();
                    for (int j = 0; j < possibilities[1 - flag].length; j++) {
                        System.out.print(possibilities[1 - flag][j] + "\t");
                    }
                    System.out.println();
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(MAX_SIDES, size);
        for (int i = size; i <= size * MAX_SIDES; i++) {
            System.out.println(i + " -> " + possibilities[flag][i] / total);
        }
    }

    public static void main(String[] args) {
        printPossibilities(3);
    }
}
