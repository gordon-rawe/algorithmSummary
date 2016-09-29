package bits;

/**
 * Created by gordon on 9/28/16.
 */
public class NumberOfOne {
    public static int numberOfOneBit(int number) {//may cause recursive call 负数会掉入死循环 如0x80000000 >> 1 -> 0xc0000000
        int count = 0;
        while (number != 0) {
            if ((number & 1) > 0) count++;
            number >>= 1;
        }
        return count;
    }

    public static int numberOfOneBitUsingMask(int number) {//计算机有多少位就会计算多少次，其实还是蛮不错的啦
        int mask = 1, count = 0;
        while (mask > 0) {
            if ((mask & number) > 0) count++;
            mask <<= 1;
        }
        return count;
    }

    public static int numberOfOneBitBest(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }

    public static int calcTwoNumberDifferentBitsCount(int src, int target) {
        int diff = src ^ target;
        return numberOfOneBit(diff);
    }

    public static void main(String[] args) {
//        System.out.println(numberOfOneBitBest(15));
        double dd = 3.2D;
        float ff = 3.2F;
        System.out.println(dd == ff);
    }
}
