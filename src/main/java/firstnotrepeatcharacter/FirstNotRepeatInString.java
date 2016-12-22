package firstnotrepeatcharacter;

/**
 * Created by gordon on 16/12/21.
 */
public class FirstNotRepeatInString {
    /*0 当成是错误，虽然0也是有可能的字符*/
    public static char firstNotRepeatChar(char[] chars) {
        if (chars == null) return 0;
        int[] flags = new int[256];/*for ascii*/
        for (int i = 0; i < flags.length; i++) {
            flags[i] = 0;
        }
        for (int i = 0; i < chars.length; i++) {
            flags[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (flags[chars[i]] == 1) return chars[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatChar("".toCharArray()));
    }
}
