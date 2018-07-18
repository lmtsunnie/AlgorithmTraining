package sword_to_offer_tree;

import java.util.ArrayList;

/* 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
   路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathToCertainSum {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) return arrayLists;
        arrayList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            arrayLists.add(new ArrayList<>(arrayList));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        // 移除最后一个元素，深度遍历完一条路径后要回退
        arrayList.remove(arrayList.size() - 1);
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
        String val = to + root.val + to;
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


    public static void printDoubleArrayList(ArrayList<ArrayList<Integer>> arrayLists) {
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 10,5,12,4,7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        printTree(root);
        printDoubleArrayList(findPath(root, 12));
    }
}
