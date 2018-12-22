package tree;

import java.util.Stack;

/*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。*/
public class ConvertBSTToSortedDoubleLinkedList {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // unrecursively
    //1.核心是中序遍历的非递归算法。
    //2.修改当前遍历节点与前一遍历节点的指针指向。
    public static TreeNode convert1(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        boolean isHead = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // pre = null
            // cur = first node of in-order sequence
            if (isHead) {
                root = cur; // set first node of in-order sequence to root
                isHead = false;
            } else {
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        return root;
    }

    public static TreeNode convert2(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = convert2(root.left);
        TreeNode right = convert2(root.right);
        if (left != null) {
            TreeNode leftLast = left;
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = root;
            root.left = leftLast;
        }
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left == null ? root : left;
    }

    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
    public static TreeNode leftLast = null;
    public static TreeNode convert3(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            leftLast = root;
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = convert3(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = convert3(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left == null ? root : left;
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

    public static void printDoubleLinkedList(TreeNode head) {
        if (head == null) return;
        System.out.print("Double Linked List: ");
        TreeNode end = null;
        System.out.print("head to end: ");
        while (head.right != null) {
            System.out.print(head.val + " -> ");
            head = head.right;
        }
        System.out.print(head.val);
        end = head;
        System.out.print(" | ");
        System.out.print("end to head: ");
        while (end.left != null) {
            System.out.print(end.val + " -> ");
            end = end.left;
        }
        System.out.println(end.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        printTree(root);
        
        printDoubleLinkedList(convert3(root));
    }
}
