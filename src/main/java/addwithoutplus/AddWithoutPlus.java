package addwithoutplus;

/**
 * Created by gordon on 16/12/21.
 */
public class AddWithoutPlus {
    public static int addWithoutPlus(int one, int two) {
        int sum, carrier;
        while (two != 0) {
            sum = one ^ two;
            carrier = (one & two) << 1;
            one = sum;
            two = carrier;
        }
        return one;
    }
}
