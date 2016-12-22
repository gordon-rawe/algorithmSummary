package nonselfmultiply;

/**
 * Created by gordon on 16/12/18.
 */
public class NoneSelfMultiply {
    public static int[] noneSelfMultiply(int[] arrayA) {
        if (arrayA == null || arrayA.length == 0) return null;
        int[] c = new int[arrayA.length];
        int[] d = new int[arrayA.length];
        int[] b = new int[arrayA.length];
        d[0] = 1;
        for (int i = 1; i < arrayA.length; i++) {
            d[i] = d[i - 1] * arrayA[i - 1];
        }
        for (int i = arrayA.length - 1; i > 0; i--) {
            c[i - 1] = c[i] * arrayA[i];
        }
        for (int i = 0; i < arrayA.length; i++) {
            b[i] = c[i] * d[i];
        }
        return b;
    }
}
