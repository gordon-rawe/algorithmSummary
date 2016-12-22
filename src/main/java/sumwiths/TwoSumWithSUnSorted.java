package sumwiths;

import java.util.HashMap;

/**
 * Created by gordon on 16/12/21.
 */
public class TwoSumWithSUnSorted {

    public static class Location {
        public int start;
        public int end;

        public Location(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    public static Location twoSumWithSUnSorted(int[] data, int value) {
        if (data == null || data.length < 2) return null;
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            Integer index = helper.get(value - data[i]);
            if (index != null) {
                return new Location(Math.min(index, i), Math.max(index, i));
            } else helper.put(data[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Location location = twoSumWithSUnSorted(new int[]{1}, 3);
        if (location != null) System.out.println(location);
    }
}
