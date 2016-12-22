package firstnotrepeatcharacter;

/**
 * Created by gordon on 16/12/21.
 */
public class FirstNotRepeatInFlow {
    private int index = 0;
    private int[] flags = new int[256];

    public FirstNotRepeatInFlow() {
        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }
    }

    public void insert(char ch) {
        if (flags[ch] == -1) flags[ch] = index;
        else flags[ch] = -2;
        index++;
    }

    /*0是异常代码，虽然char也包含了它，现在特殊约定*/
    public char firstNotRepeatChar() {
        if (index == 0) return 0;
        int min = Integer.MAX_VALUE;
        char ch = 0;
        for (char i = 0; i < flags.length; i++) {
            if (flags[i] < min && flags[i] >= 0) {/*这个数是有效的，序号为flags[i]*/
                min = flags[i];
                ch = i;
            }
        }
        return ch;
    }
}
