package pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 16/12/21.
 */
public class PascalTriangle {
    public static List<List<Integer>> pascalTriangle(int rows) {
        List<List<Integer>> retValue = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> thisRow = new ArrayList<>();
            thisRow.add(1);
            if (i > 1) {
                List<Integer> lastRow = retValue.get(i - 1);
                for (int j = 1; j < i; j++) {
                    thisRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            if (i > 0) thisRow.add(1);
            retValue.add(thisRow);
        }
        return retValue;
    }

    public static void main(String[] args) {
        List<List<Integer>> s = pascalTriangle(5);
        System.out.println(s);
    }
}
