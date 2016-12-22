package sumwiths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 16/12/21.
 */
public class SumWithS {

    /**
     * 输出任意一组即可
     * 输出两个数字的坐标
     */
    public static Location twoSumWithS(int[] data, int value) {
        if (data == null || data.length < 2) return null;
        int pre = 0, end = data.length - 1;
        while (pre < end) {
            if (data[pre] + data[end] == value) return new Location(pre, end);
            else if (data[pre] + data[end] > value) {
                end--;
            } else pre++;
        }
        return null;
    }

    /**
     * 输出全部
     * 输出满足要求的集合，考虑如下一些特殊输入
     * 1227889->10
     * 12223->4
     * 22222->4
     * null
     */
    public static List<Location> twoSumWithSAll(int[] data, int value) {
        List<Location> retValue = new ArrayList<>();
        if (data == null || data.length < 2) return retValue;
        int pre = 0, end = data.length - 1;
        while (pre < end) {
            if (data[pre] + data[end] == value) {
                int mark1 = pre, mark2 = end;
                while (pre < data.length - 1 && data[pre + 1] == data[pre]) {
                    pre++;
                }
                while (end > 0 && data[end - 1] == data[end]) {
                    end--;
                }
                for (int i = mark1; i <= pre; i++) {
                    for (int j = end; j <= mark2; j++) {
                        if (i < j) retValue.add(new Location(i, j));
                    }
                }
                pre++;
            } else if (data[pre] + data[end] > value) {
                end--;
            } else pre++;
        }
        return retValue;
    }

    public static class Location {
        public int start;
        public int end;

        public Location(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        List<Location> result = twoSumWithSAll(new int[]{1, 2, 2, 2}, 4);
        for (Location location : result) {
            System.out.println(location.start + " " + location.end);
        }
    }
}
