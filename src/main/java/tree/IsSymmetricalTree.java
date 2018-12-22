package tree;

public class IsSymmetricalTree {
    public static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /* 递归：
     * 左子树 = 右子树
     * 左子树的左子树 = 右子树的右子树
     * 左子树的右子树 = 右子树的左子树
     * */
    public static boolean isSymmetrical(TreeNode root) {
        if (root == null) return true;
        return isSymmetrical(root.left, root.right);
    }

    // 对称位置相等
    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.value != right.value) return false;
        return isSymmetrical(left.right, right.left) && isSymmetrical(left.left, right.right);
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-222222222);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(Integer.MIN_VALUE);
        root.right.left = new TreeNode(55555555);
        root.right.right = new TreeNode(66);
        root.left.left.right = new TreeNode(777);
        printTree(root);
        System.out.println(isSymmetrical(root));
        System.out.println("=============================");

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        printTree(root);
        System.out.println(isSymmetrical(root));
        System.out.println("==============================");

        root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        printTree(root);
        System.out.println(isSymmetrical(root));
        System.out.println("==============================");
    }
}

