package clockwisearray;

/**
 * Created by gordon on 9/29/16.
 */
public class ClockArrayPrint {
    public static int[][] buildSampleArray() {
        return new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
    }

    public static void printClockWise(int[][] array, int columns, int rows) {
        if (array == null || columns <= 0 || rows <= 0) return;
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printCircle(array, columns, rows, start);
            start++;
        }
    }

    public static void printCircle(int[][] array, int columns, int rows, int start) {
        int endX = columns - start - 1;
        int endY = rows - start - 1;
        for (int i = 0; i <= endX; i++) {
            System.out.print(array[start][i] + " ");
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(array[i][endX] + " ");
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(array[endY][i] + " ");
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                System.out.print(array[i][start] + " ");
            }
        }
    }

    public static void main(String[] args) {
        printClockWise(buildSampleArray(),4,4);
    }
}
