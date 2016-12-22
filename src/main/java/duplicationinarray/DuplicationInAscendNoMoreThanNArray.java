package duplicationinarray;

/**
 * Created by gordon on 16/12/21.
 */
public class DuplicationInAscendNoMoreThanNArray {

    public static int duplcate(int[] data) {
        if (data == null || data.length <= 1) return -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0 || data[i] > data.length - 1) return -1;
        }
        for (int i = 0; i < data.length; i++) {
            while (data[i] != i) {
                if (data[i] == data[data[i]]) return data[i];
                int tmp = data[i];
                data[i] = data[tmp];
                data[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(duplcate(new int[]{1,2,3,3,4}));
    }
}
