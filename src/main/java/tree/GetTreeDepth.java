package tree;

import java.util.LinkedList;
import java.util.Queue;

public class GetTreeDepth {
    public static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;

        }
    }

    // recursively
    public static int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth1(root.left), TreeDepth1(root.right)) + 1;
    }

    // unrecursively
    // count为该层从队列中弹出的节点的个数，nextLayerCount为在队列中的元素个数，即下一层的节点的总个数
    public static int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0, count = 0, nextLayerCount = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            count++;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (count == nextLayerCount) {
                nextLayerCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    public static void printTree(TreeNode root) {
        System.out.println("Binary Tree:");
        printInOrder(root, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode root, int height, String to, int len) {
        if (root == null) {
            return;
        }
        printInOrder(root.right, height + 1, "v", len);
        String value = to + root.value + to;
        int lenM = value.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        value = getSpace(lenL) + value + getSpace(lenR);
        System.out.println(getSpace(height * len) + value);
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(11);
        printTree(root);
        System.out.println(TreeDepth1(root));
        System.out.println(TreeDepth2(root));
    }
}