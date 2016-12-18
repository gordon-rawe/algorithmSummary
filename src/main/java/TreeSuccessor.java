/**
 * Created by gordon on 16/12/3.
 */
public class TreeSuccessor {
    public static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;
    }

    public static BinaryTreeNode successor(BinaryTreeNode node) {
        if(node==null)
            return null;
        BinaryTreeNode ret = null;
        if(node.right!=null){
            BinaryTreeNode right = node.right;
            while (right.left!=null) right = right.left;
            ret = right;
        }else if(node.parent!=null) {
            BinaryTreeNode current = node;
            BinaryTreeNode parent = node.parent;
            while (parent!=null && current == parent.right){
                current = parent;
                parent = parent.parent;
            }
            ret = parent;
        }
        return ret;
    }
}
