package reversewordsinscentence;

/**
 * Created by gordon on 16/12/19.
 */
public class ReverseScentenceWordsOrder {
    public static void reverse(char[] data, int startIndex, int endIndex) {
        if (data == null || startIndex > data.length - 1 || endIndex > data.length - 1) return;
        while (startIndex < endIndex) {
            char tmp = data[startIndex];
            data[startIndex++] = data[endIndex];
            data[endIndex--] = tmp;
        }
    }

    public static void reverseWords(char[] data) {
        if (data == null) return;
        reverse(data, 0, data.length - 1);
        int p1 = 0, p2 = 0;
        while (p1 < data.length) {
            if (data[p1] == ' ') {
                p1++;
                p2++;
            } else if (p2 >= data.length || data[p2] == ' ') {
                reverse(data, p1, --p2);
                p1 = ++p2;
            } else {
                p2++;
            }
        }
    }

    public static void leftRotate(char[] data, int n) {
        if (data == null || data.length == 0 || n % data.length == 0) return;
        n = n % data.length;
        reverse(data,0,n);
        reverse(data,n+1,data.length-1);
        reverse(data,0,data.length-1);
    }

    public static void main(String[] args) {
        char[] sample = "I am a student.".toCharArray();
        leftRotate(sample,2);
        String result = String.copyValueOf(sample);
        System.out.println(result);
    }
}
