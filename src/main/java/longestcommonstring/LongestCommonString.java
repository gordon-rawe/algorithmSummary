package longestcommonstring;

/**
 * Created by gordon on 16/12/21.
 */
public class LongestCommonString {
    public static String longestCommonString(String one, String two) {
        int len1 = one.length(), len2 = two.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        /**
         * 初始化dp数组
         * */
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = 0;
        }
        int max = Integer.MIN_VALUE, start = 0;
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = 0;
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                }
            }
        }
        if (max == Integer.MIN_VALUE) return "";
        char[] result = new char[max];
        max--;
        start--;
        while (max >= 0) {
            result[max--] = one.charAt(start--);
        }
        return String.copyValueOf(result);
    }

    public static int longestCommonStringRule(String one, String two) {
        int len1 = one.length(), len2 = two.length(), len = len1 + len2, max = 0;
        for (int i = 0; i < len; i++) {
            int start1 = 0, start2 = 0;
            if (i < len1) {
                start1 = len1 - i;
            } else {
                start2 = i - len1;
            }
            int curMax = 0;
            for (int j = 0; j + start1 < len1 && j + start2 < len2; j++) {
                if (one.charAt(j + start1) == two.charAt(j + start2)) {
                    curMax++;
                } else {
                    if (curMax > max) max = curMax;
                    curMax = 0;
                }
            }
            if (curMax > max) max = curMax;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonStringRule("gordon rawe", "gordon"));
    }

    public static int[][] backPackSolution(int[] weights, int[] values, int weightLimit) {
        int len = weights.length;
        if (len != values.length) return null;
        int[][] result = new int[len + 1][weightLimit + 1];
        for (int i = 0; i < len + 1; i++) {
            result[i][0] = 0;
        }
        for (int i = 0; i < weightLimit + 1; i++) {
            result[0][i] = 0;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < weightLimit + 1; j++) {
                if (j > weights[i] && result[i - 1][j - weights[i]] + values[i] > result[i - 1][j]) {
                    result[i][j] = result[i - 1][j - weights[i]] + values[i];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result;
    }
}
