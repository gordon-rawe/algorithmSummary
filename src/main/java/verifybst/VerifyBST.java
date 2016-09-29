package verifybst;

/**
 * Created by gordon on 16/9/29.
 */
public class VerifyBST {
    public static int[] generateArray() {
        return new int[]{5, 7, 6, 9, 11, 10, 8};
    }

    public static boolean verifyBST(int[] array, int len) {
        if (array == null || array.length == 0) return false;
        int root = array[len - 1], pointer = 0;
        while (pointer < len - 1 && array[pointer] > root) pointer++;
        for (int i = pointer; i < len - 1; i++) {
            if(array[i] < root) return false;
        }
        boolean leftVerified = true;
        if (pointer > 0) leftVerified = verifyBST(array, pointer);
        boolean rightVerified = true;
        if (pointer < len - 1) rightVerified = verifyBST(array, len - pointer - 1);
        return leftVerified && rightVerified;
    }

    public static void main(String[] args) {
        int[] array = generateArray();
        System.out.println(verifyBST(array, array.length));
    }
}
