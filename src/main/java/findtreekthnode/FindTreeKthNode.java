package findtreekthnode;

import subtreejudge.TreeNode;

/**
 * Created by gordon on 16/12/21.
 */
public class FindTreeKthNode {
    private int k;
    private TreeNode root;

    public FindTreeKthNode(int k, TreeNode root) {
        this.k = k;
        this.root = root;
    }

    public TreeNode findKthNode() {
        if (k == 0 || root == null) return null;
        return findKthNodeCore(root);
    }

    private TreeNode findKthNodeCore(TreeNode root) {
        TreeNode node = null;
        if (root.left != null) node = findKthNodeCore(root.left);
        if (node == null) {
            if (k == 1) node = root;
            k--;
        }
        if (node == null && root.right != null) node = findKthNodeCore(root.right);
        return node;
    }
}
