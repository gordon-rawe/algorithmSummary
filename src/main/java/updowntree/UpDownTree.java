package updowntree;

import subtreejudge.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gordon on 9/29/16.
 */
public class UpDownTree {
    public static void printTreeFromTopToBottom(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode tmpNode = queue.poll();
            System.out.println(tmpNode.value);
            if (tmpNode.left != null) queue.add(tmpNode.left);
            if (tmpNode.right != null) queue.add(tmpNode.right);
        }
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = treeDepth(root.left), right = treeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static boolean isBlanced(TreeNode node) {
        if (node == null) return true;
        int left = treeDepth(node.left);
        int right = treeDepth(node.right);
        if (left - right <= 1 && left - right >= -1) return true;
        return isBlanced(node.left) && isBlanced(node.right);
    }

    public static void reverseTree(TreeNode root) {
        if (root == null) return;
        if (root.left != null) reverseTree(root.left);
        if (root.right != null) reverseTree(root.right);
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
    }

    public static void main(String[] args) {
        printTreeFromTopToBottom(TreeNode.buildBigTree());
        System.out.println(isBlanced(TreeNode.buildBigTree()));
    }
}
