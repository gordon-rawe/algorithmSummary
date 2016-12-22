package removearrayduplicates;

/**
 * Created by gordon on 16/12/21.
 */
public class RemoveArrayDuplicates {


    /**
     * 要求：原位，不使用辅助容器
     * 基本思路是，使用一个下标，记录现在不重复的元素到哪个位置了，遍历所有元素，执行操作
     */
    public static void removeDuplicates(int[] data) {
        if (data == null || data.length < 2) return;
        int index = 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) data[index++] = data[i];
        }
        for (int i = index; i < data.length; i++) {
            data[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 4, 3, 4, 6, 4, 4, 5, 5, 4, 7, 9, 8, 6, 8, 9, 4, 5, 5};
        removeDuplicates(data);
        for (int i : data) {
            System.out.print(i);
        }

    }
}
