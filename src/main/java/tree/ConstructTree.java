package tree;

/**
 * Created by gordon on 9/28/16.
 */
public class ConstructTree {
    public static TreeNode constructTree(int[] preOrder, int[] midOrder) {
        if (preOrder == null || midOrder == null || preOrder.length != midOrder.length) return null;
        try {
            return constructCore(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TreeNode constructCore(int[] preOrder, int preStart, int preEnd, int[] midOrder, int midStart, int midEnd) throws Exception {
        int rootValue = preOrder[preStart];
        TreeNode rootNode = new TreeNode(rootValue);
        /** only one member... */
        if (preStart == preEnd && midStart == midEnd && preOrder[preStart] == midOrder[midStart]) {
            return rootNode;
        }

        int midRootIndex = midStart;
        while (midRootIndex <= midEnd && rootValue != midOrder[midRootIndex]) {
            midRootIndex++;
        }

        if (midRootIndex == midEnd && midOrder[midRootIndex] != rootValue) throw new Exception("bad input array...");

        int leftMidAreaSize = midRootIndex - midStart;
        int leftPreAreaSize = preStart + leftMidAreaSize;
        if (leftMidAreaSize > 0)
            rootNode.left = constructCore(preOrder, preStart + 1, leftPreAreaSize, midOrder, midStart, midRootIndex - 1);
        if (leftMidAreaSize < midEnd - midStart)
            rootNode.right = constructCore(preOrder, leftPreAreaSize + 1, preEnd, midOrder, midRootIndex + 1, midEnd);

        return rootNode;
    }

    public static void printPreOrder(TreeNode rootNode) {
        if (rootNode == null) return;
        System.out.println(rootNode.value);
        if (rootNode.left != null) printPreOrder(rootNode.left);
        if (rootNode.right != null) printPreOrder(rootNode.right);
    }

    public static void printMidOrder(TreeNode rootNode) {
        if (rootNode == null) return;
        if (rootNode.left != null) printMidOrder(rootNode.left);
        System.out.println(rootNode.value);
        if (rootNode.right != null) printMidOrder(rootNode.right);
    }

    public static void printAfterOrder(TreeNode rootNode) {
        if (rootNode == null) return;
        if (rootNode.left != null) printAfterOrder(rootNode.left);
        if (rootNode.right != null) printAfterOrder(rootNode.right);
        System.out.println(rootNode.value);
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = constructTree(preOrder, midOrder);
        System.out.println("/** pre order */");
        printPreOrder(tree);
        System.out.println("/** mid order */");
        printMidOrder(tree);
        System.out.println("/** after order */");
        printAfterOrder(tree);
    }
}
