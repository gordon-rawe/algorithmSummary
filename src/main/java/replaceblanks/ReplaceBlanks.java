package replaceblanks;

/**
 * Created by gordon on 16/11/26.
 */
public class ReplaceBlanks {

    /**
     * 将一个字符串中的空格原位替换为20%,模拟网络传输,有一个前提，假设数组长度足够长，并且以'*'结尾
     */
    public static void replace(char[] src, char target, char[] to) {
        int count = 0, countOfEmpty = 0;
        for (int i = 0; i < src.length; i++) {
            if (target == src[i]) {
                countOfEmpty++;
            }
            count++;
            if (src[i] == '\n') break;
        }
        if (countOfEmpty == 0) return;
        int celling = (to.length - 1) * countOfEmpty + count - 1, origin = count - 1;
        if (celling + 1 > src.length) {
            System.out.println("src length is not enough");
            return;
        }
        while (origin >= 0 && celling >= 0) {
            if (target == src[origin]) {
                for (int i = 0; i < to.length; i++) {
                    src[celling--] = to[to.length - i - 1];
                }
                origin--;
            } else {
                src[celling--] = src[origin--];
            }
        }
    }


    public static void main(String[] args) {
        char[] src = new char[]{'h', ' ', 'e', ' ', 'l', ' ', 'l', '\n', ' ', ' ', ' ', ' ', ' ', ' '};
        replace(src, ' ', "%20".toCharArray());
        for (char c : src) {
            System.out.println(c);
        }

    }
}
