package subtreejudge;

/**
 * Created by gordon on 9/29/16.
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode buildBigTree() {
        TreeNode rootNode = new TreeNode(8);
        TreeNode tmpValue = rootNode.left = new TreeNode(8);
        rootNode.right = new TreeNode(7);
        tmpValue.left = new TreeNode(9);
        tmpValue = tmpValue.right = new TreeNode(2);
        tmpValue.left = new TreeNode(4);
        tmpValue.right = new TreeNode(7);
        return rootNode;
    }

    public static TreeNode buildChildTree() {
        TreeNode childNode = new TreeNode(8);
        childNode.left = new TreeNode(9);
        childNode.right = new TreeNode(2);
        return childNode;
    }

    public static boolean containChildTree(TreeNode parent, TreeNode child) {
        boolean retValue = false;
        if (parent != null && child != null) {
            if (parent.value == child.value) retValue = compareTree(parent, child);
            if (!retValue) retValue = containChildTree(parent.left, child);
            if (!retValue) retValue = containChildTree(parent.right, child);
        }
        return retValue;
    }

    public static boolean compareTree(TreeNode parent, TreeNode child) {
        if (child == null) return true;
        if (parent == null) return false;
        if (parent.value != child.value) return false;
        return compareTree(parent.left, child.left) && compareTree(parent.right, child.right);
    }

    public static void traverse(TreeNode rootNode) {
        if (rootNode == null) return;
        System.out.println(rootNode.value);
        if (rootNode.left != null) traverse(rootNode.left);
        if (rootNode.right != null) traverse(rootNode.right);
    }

    public static boolean sameTree(TreeNode src, TreeNode dest) {
        if (src == null && dest == null) return true;
        if (src == null || dest == null) return false;
        if (src.value != dest.value) return false;
        return sameTree(src.left, dest.left) && sameTree(src.right, dest.right);
    }

    public static boolean containTree(TreeNode parent, TreeNode child) {
        if (child == null) return true;
        if (parent == null) return false;
        if (parent.value != child.value) return false;
        return containTree(parent.left, child.left) && containTree(parent.right, child.right);
    }

    public static boolean judgeSubTree(TreeNode parent, TreeNode child) {
        boolean found = false;
        if (parent != null && child != null) {
            found = containTree(parent, child);
            if (!found) found = judgeSubTree(parent.left, child);
            if (!found) found = judgeSubTree(parent.right, child);
        }
        return found;
    }

    public static void main(String[] args) {
        traverse(buildBigTree());
        System.out.println(containChildTree(buildBigTree(), buildChildTree()));
        System.out.println(sameTree(buildBigTree(), buildBigTree()));
    }

    public static boolean sameTrees(TreeNode one,TreeNode two){
        if(one==null && two==null)return true;
        if(one==null||two==null)return false;
        if(one.value!=two.value)return false;
        return sameTrees(one.left,two.left)&&sameTrees(one.right,two.right);
    }

}
