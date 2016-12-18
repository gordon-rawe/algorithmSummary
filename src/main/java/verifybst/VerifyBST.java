package verifybst;

import subtreejudge.TreeNode;

import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by gordon on 16/9/29.
 */
public class VerifyBST {
    public static int[] generateArray() {
        return new int[]{5, 7, 6, 9, 11, 10, 8};
    }

    public static boolean verifyBST(int[] array, int len) {
        if (array == null || array.length == 0) return false;
        int root = array[len - 1], pointer = 0;
        while (pointer < len - 1 && array[pointer] > root) pointer++;
        for (int i = pointer; i < len - 1; i++) {
            if (array[i] < root) return false;
        }
        boolean leftVerified = true;
        if (pointer > 0) leftVerified = verifyBST(array, pointer);
        boolean rightVerified = true;
        if (pointer < len - 1) rightVerified = verifyBST(array, len - pointer - 1);
        return leftVerified && rightVerified;
    }

    public static boolean verifyAfterBST(int[] array, int start, int end) {
        if (start == end) return true;
        int root = array[end], pointer = start;
        while (pointer < end - 1 && array[pointer] < root) pointer++;
        /**
         * pointer现在应该指向左子树的max指数那么左右为(start -> pointer-1,pointer -> end-1)
         * */
        for (int p = pointer + 1; p < end; p++) {
            if (array[p] < root) return false;
        }
        boolean leftVerified = true;
        if (pointer >= start) leftVerified = verifyAfterBST(array, start, pointer - 1);
        boolean rightVerified = true;
        if (pointer <= end - 1) rightVerified = verifyAfterBST(array, pointer, end - 1);
        return leftVerified && rightVerified;
    }

    public static void main(String[] args) {
        int[] array = generateArray();
        System.out.println(verifyAfterBST(array, 0, array.length - 1));
    }

    public void findPath(TreeNode root, int k) {
        if (root == null)
            return;
        Stack<Integer> stack = new Stack<>();
        findPath(root, k, stack);
    }

    public void findPath(TreeNode root, int k, Stack<Integer> path) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.value == k) {
                System.out.println("路径开始");
                for (int i : path)
                    System.out.print(i + ",");
                System.out.print(root.value);
            }
        } else {
            path.push(root.value);
            findPath(root.left, k - root.value, path);
            findPath(root.right, k - root.value, path);
            path.pop();
        }
    }

    Integer[] getLeaskNumbers(int[] src, int k) {
        if (k < 1 || src.length < k) return null;
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < src.length; i++) {
            if (sortedSet.size() < k) {
                sortedSet.add(src[i]);
            } else {
                if (src[i] < sortedSet.first()) {
                    sortedSet.remove(sortedSet.first());
                    sortedSet.add(src[i]);
                }
            }
        }
        Integer[] ret = null;
        if (sortedSet.size() == k) {
            ret = new Integer[k];
            sortedSet.toArray(ret);
        }
        return ret;
    }
}
