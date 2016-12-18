package mirrortree;

import subtreejudge.TreeNode;

/**
 * Created by gordon on 9/29/16.
 */
public class MirrorTree {

    public static void mirrorTree(TreeNode head) {
        if (head == null) return;
        if (head.left == null && head.right == null) return;
        /*交换*/
        TreeNode tmpNode = head.left;
        head.left = head.right;
        head.right = tmpNode;
        if (head.left != null) mirrorTree(head.left);
        if (head.right != null) mirrorTree(head.right);
    }
}
