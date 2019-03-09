package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToBottom {
    public static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void printArrayList(ArrayList<Integer> arrayList) {
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printDoubleArrayList(ArrayList<ArrayList<Integer>> arrayLists) {
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> getArrayListFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            arrayList.add(treeNode.value);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return arrayList;
    }

    public static void printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.value + " ");
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        System.out.println();
    }

    // count为该层从队列中弹出的节点的个数，nextLayerCount为在队列中的元素个数，即下一层的节点的总个数
    public static void printFromTopToBottomWithChangeLine(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        int nextLayerCount = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            count++;
            System.out.print(treeNode.value + " ");
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            if (count == nextLayerCount) {
                System.out.println();
                count = 0;
                nextLayerCount = queue.size();
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getDoubleArrayFromTopToBottomWithChangeLine(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null) return arrayLists;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        int count = 0;
        int nextLayerCount = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            layerList.add(treeNode.value);
            count++;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
            if (count == nextLayerCount) {
                arrayLists.add(layerList);
                count = 0;
                nextLayerCount = queue.size();
                layerList = new ArrayList<>();
            }
        }
        return arrayLists;
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
        System.out.println("PrintArrayList(getArrayListFromTopToBottom(root)): ");
        printArrayList(getArrayListFromTopToBottom(root));
        System.out.println("printFromTopToBottom(root): ");
        printFromTopToBottom(root);
        System.out.println("printFromTopToBottomWithChangeLine(root): ");
        printFromTopToBottomWithChangeLine(root);
        System.out.println("PrintDoubleArrayList(getDoubleArrayFromTopToBottomWithChangeLine(root)): ");
        printDoubleArrayList(getDoubleArrayFromTopToBottomWithChangeLine(root));
    }
}

