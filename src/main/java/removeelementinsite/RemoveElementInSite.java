package removeelementinsite;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gordon on 16/12/21.
 */
public class RemoveElementInSite {

    public static int removeElementInSite(int[] data, int value) {
        if (data == null || data.length < 1) return 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != value) data[index++] = data[i];
            else count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 2, 3, 4};
        System.out.println(removeElementInSite(data, 3));
        for (int i : data) {
            System.out.print(i);
        }
        System.out.println("------");
        int[] dataList = new int[]{1,2,3};
        System.out.println(summarizeArray(dataList));
    }

    public static boolean hashDuplicates(int[] data) {
        if (data == null || data.length < 2) return false;
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (helper.get(data[i]) == null) helper.put(data[i], 1);
            else return true;
        }
        return false;
    }

    public static List<Pair<Integer, Integer>> summarizeArray(int[] data) {
        List<Pair<Integer, Integer>> retValue = new ArrayList<>();
        if (data == null || data.length == 0) return retValue;
        if (data.length == 1) {
            retValue.add(new Pair<>(0, 0));
        }
        int index = 0;
        while (index < data.length - 1) {
            if (data[index] + 1 == data[index + 1]) {
                int p = index + 1;
                while (p < data.length - 1 && data[p] + 1 == data[p + 1]) p++;
                retValue.add(new Pair<>(index, p));
                index = p + 1;
            } else {
                retValue.add(new Pair<>(index, index));
                index++;
            }
        }
        return retValue;
    }
}
