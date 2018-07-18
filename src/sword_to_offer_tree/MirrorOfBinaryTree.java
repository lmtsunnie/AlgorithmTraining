package sword_to_offer_tree;

import java.util.Stack;

public class MirrorOfBinaryTree {
    public static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // recursively
    public static void mirror1(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            mirror1(root.left);
        }
        if (root.right != null) {
            mirror1(root.right);
        }
    }

    // unrecursively
    // 手动压栈弹栈，先换下层再换上层 -> 弹栈时要求先弹出下层节点再弹出上层节点 -> 先将上层压栈后再将下层压栈
    public static void mirror2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.left != null || treeNode.right != null) {
                TreeNode tmp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = tmp;
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
    }

    public static void printTree(TreeNode root) {
        //System.out.println("Binary Tree:");
        printInOrder(root, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode root, int height, String to, int len) {
        if (root == null) {
            return;
        }
        printInOrder(root.right, height + 1, "v", len);
        String val = to + root.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(root.left, height + 1, "^", len);
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-222222222);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(Integer.MIN_VALUE);
        root.right.left = new TreeNode(55555555);
        root.right.right = new TreeNode(66);
        root.left.left.right = new TreeNode(777);
        System.out.println("before mirror1: ");
        printTree(root);
        mirror2(root);
        System.out.println("after mirror1: ");
        printTree(root);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        System.out.println("before mirror1: ");
        printTree(root);
        mirror2(root);
        System.out.println("after mirror1: ");
        printTree(root);

        root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        System.out.println("before mirror1: ");
        printTree(root);
        mirror2(root);
        System.out.println("after mirror1: ");
        printTree(root);
    }
}
