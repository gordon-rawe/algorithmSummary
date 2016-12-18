package searchtree2linkedlist;

/**
 * Created by gordon on 16/10/24.
 */
public class SearchTree2LinkedList {
    private static class TreeNode {
        public int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
        }

        static TreeNode buildTree() {
            TreeNode root = new TreeNode(10);
            TreeNode nodeL = root.left = new TreeNode(6);
            TreeNode nodeR = root.right = new TreeNode(14);
            nodeL.left = new TreeNode(4);
            nodeL.right = new TreeNode(8);
            nodeR.left = new TreeNode(12);
            nodeR.right = new TreeNode(16);
            return root;
        }
    }

    private static TreeNode searchTreeToLinkedList(TreeNode root) {
        if (root == null) return root;
        TreeNode[] lastNodes = new TreeNode[1];
        traverseNode(root, lastNodes);
        while (lastNodes[0].left != null) lastNodes[0] = lastNodes[0].left;
        return lastNodes[0];
    }

    public static void traverseNode(TreeNode node, TreeNode[] lastNodes) {
        if (node == null) return;
        if (node.left != null) traverseNode(node.left, lastNodes);
        node.left = lastNodes[0];
        if (lastNodes[0] != null) lastNodes[0].right = node;
        lastNodes[0] = node;
        if (node.right != null) traverseNode(node.right, lastNodes);
    }

    public static void main(String[] args) {
        TreeNode head = tree2link(TreeNode.buildTree());
        while (head != null) {
            System.out.println(head.value);
            head = head.right;
        }
    }

    public static TreeNode head;

    public static TreeNode tree2link(TreeNode root) {
        if (root == null) return root;
        traverseNodes(root);
        while (head.left!=null) head = head.left;
        return head;
    }

    public static void traverseNodes(TreeNode node) {
        if(node==null)return;
        if(node.left!=null)traverseNodes(node.left);
        node.left = head;
        if(head!=null) head.right = node;
        head = node;
        if(node.right!=null) traverseNodes(node.right);
    }
}
