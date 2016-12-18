package searchin2darray;

/**
 * Created by gordon on 16/11/24.
 */
public class SearchIn2DArray {

    public static final int[] arr = new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};

    public static boolean searchNumberIn2DArray(int[] src, int row, int col, int number) {
        boolean found = false;
        if (src != null && row > 0 && col > 0) {
            int r = 0, c = col - 1;
            while (r < row && c >= 0) {
                if (src[r * col + c] == number) {
                    found = true;
                    break;
                } else if (src[r * col + c] > number) {
                    c--;
                } else {
                    r++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(searchIn2DArray(arr, 4, 4, 7));
    }

    public static boolean searchIn2DArray(int[] src, int rows, int cols, int number) {
        boolean found = false;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (src[cols * row + col] == number) {
                found = true;
                break;
            } else if (src[cols * row + col] > number) col--;
            else row++;
        }
        return found;
    }

}
