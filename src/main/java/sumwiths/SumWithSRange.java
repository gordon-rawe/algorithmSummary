package sumwiths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 16/12/21.
 */
public class SumWithSRange {

    public static void main(String[] args) {
        for (Location location : sumWithSRange(100)) {
            System.out.println(location.start+" "+location.end);
        }
    }

    public static List<Location> sumWithSRange(int value) {
        List<Location> retValue = new ArrayList<>();
        if (value < 3) return retValue;
        int small = 1, big = 2, curSum = small + big;
        while (small < (value + 1) / 2) {
            if (curSum == value) {
                retValue.add(new Location(small, big));
                big++;
                curSum += big;
            } else if (curSum > value) {
                curSum -= small;
                small++;
            } else {
                big++;
                curSum += big;

            }
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
}
