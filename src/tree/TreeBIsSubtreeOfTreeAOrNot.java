package tree;

// 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class TreeBIsSubtreeOfTreeAOrNot {
    public static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        boolean res = isSameOrMore(root1, root2);
        if (!res) {
            res = isSameOrMore(root1.left, root2);
        }
        if (!res) {
            res = isSameOrMore(root1.right, root2);
        }
        return res;
    }

    public static boolean isSameOrMore(TreeNode root1, TreeNode root2) {
        // root2子树已经遍历完了，true
        if (root2 == null) return true;
        // root1母树已经遍历完了但root2子树没有遍历完,false
        if (root1 == null) return false;

        if (root1.value != root2.value) return false;
        return isSameOrMore(root1.left, root2.left) && isSameOrMore(root1.right, root2.right);
    }

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
        String value = to + head.value + to;
        int lenM = value.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        value = getSpace(lenL) + value + getSpace(lenR);
        System.out.println(getSpace(height * len) + value);
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
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(7);

        System.out.println("root1: ");
        printTree(root1);
        System.out.println("root2: ");
        printTree(root2);

        System.out.println(isSubtree(root1, root2));

        root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println("root1: ");
        printTree(root1);
        System.out.println("root2: ");
        printTree(root2);

        System.out.println(isSubtree(root1, root2));
    }
}
