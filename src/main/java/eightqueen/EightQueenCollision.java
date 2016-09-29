package eightqueen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 16/9/29.
 */
public class EightQueenCollision {

    public static List<String> results = new ArrayList<>();

    public static void findEightQueenPositions() {
        int[] fillNumbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        recurse(fillNumbers, fillNumbers.length, 0);
        results.forEach(System.out::println);
    }

    public static void swap(int[] src, int from, int to) {
        int tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static void recurse(int[] fillNumbers, int length, int index) {
        if (index == length - 1) {
            if (matchQueenRule(fillNumbers))
                results.add(getArrayString(fillNumbers));
            return;
        }
        for (int i = index; i < length; i++) {
            swap(fillNumbers, i, index);
            recurse(fillNumbers, length, index + 1);
            swap(fillNumbers, i, index);
        }
    }

    public static boolean matchQueenRule(int[] combinations) {
        int allMatch = 0;
        int allTimes = combinations.length * (combinations.length - 1);
        for (int i = 0; i < combinations.length; i++) {
            for (int j = 0; j < combinations.length; j++) {
                if (i != j && i - j != combinations[i] - combinations[j] && i - j != combinations[j] - combinations[i])
                    allMatch++;
            }
        }
        return allMatch == allTimes;
    }

    public static String getArrayString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        findEightQueenPositions();
    }
}
