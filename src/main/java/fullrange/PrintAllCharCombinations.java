package fullrange;

/**
 * Created by gordon on 16/9/29.
 */
public class PrintAllCharCombinations {

    public static void findEightQueenPositions(String input) {
        char[] fillNumbers = input.toCharArray();
        recurse(fillNumbers, fillNumbers.length, 0);
    }

    public static void swap(char[] src, int from, int to) {
        char tmp = src[from];
        src[from] = src[to];
        src[to] = tmp;
    }

    public static void recurse(char[] fillNumbers, int length, int index) {
        if (index == length - 1) {
            printArray(fillNumbers);
            return;
        }
        for (int i = index; i < length; i++) {
            swap(fillNumbers, i, index);
            recurse(fillNumbers, length, index + 1);
            swap(fillNumbers, i, index);
        }
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        char[] source = "abc".toCharArray();
        recurse(source,source.length,0);
    }
}
