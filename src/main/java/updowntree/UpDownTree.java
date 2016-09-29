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

    public static void main(String[] args) {
        printTreeFromTopToBottom(TreeNode.buildBigTree());
    }
}
