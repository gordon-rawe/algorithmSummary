package kmp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 16/11/25.
 */
public class KMPSearch {
    public static int[] process(char[] pattern) {
        int[] retArray = new int[pattern.length + 1];
        int i = 0, j = -1;
        retArray[i] = j;
        while (i < pattern.length) {
            while (j >= 0 && pattern[i] != pattern[j]) j = retArray[j];
            i++;
            j++;
            retArray[i] = j;
        }
        return retArray;
    }

    public static List<Integer> searchKMP(char[] src, char[] pattern) {
        List<Integer> retArray = new ArrayList<>();
        int srcLen = src.length, patLen = pattern.length, i = 0, j = 0;
        int[] ref = process(pattern);
        while (i < srcLen) {
            while (j >= 0 && src[i] != pattern[j]) j = ref[j];
            i++;
            j++;
            if (j == patLen) {
                retArray.add(i - patLen);
                j = ref[j];
            }
        }
        return retArray;
    }

    public static void main(String[] args) {
        searchKMP("gordon rawboye is a handsome boy".toCharArray(), "boy".toCharArray()).forEach(System.out::println);
    }
}
