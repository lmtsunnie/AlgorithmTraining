package tree;

public class KthBiggestNodeOfBST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static int index = 0; //计数器
    public static TreeNode kthNode(TreeNode root, int k) {
        //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
        //所以，按照中序遍历顺序找到第k个结点就是结果。
        if (root != null) { //中序遍历寻找第k个
            TreeNode treeNode = kthNode(root.left, k);
            if (treeNode != null)
                return treeNode;
            index++;
            if (index == k)
                return root;
            treeNode = kthNode(root.right, k);
            if (treeNode != null)
                return treeNode;
        }
        return null;
    }

    // for LinkedListHasLoopOrNot -- Print tree
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);

        printTree(head);
        System.out.println(kthNode(head, 1).val);
    }
}

    

