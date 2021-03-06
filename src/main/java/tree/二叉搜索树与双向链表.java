package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static common.PrintBinaryTree.printTree;
import static common.PrintLinkedList.printDoubleTreeNode;

public class 二叉搜索树与双向链表 {
    /*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。*/

    /**
     * 中序遍历的时候pre的右指针指向cur，cur的左指针指向pre即可
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode[] pre = new TreeNode[1];
        helper(pRootOfTree, pre);
        //已经完成双向链表的链接，找链表头节点返回
        TreeNode cur = pRootOfTree;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public static void helper(TreeNode root, TreeNode[] pre) {
        if (root.left != null) {
            helper(root.left, pre);
        }
        root.left = pre[0];
        if (pre[0] != null) {
            pre[0].right = root;
        }
        pre[0] = root;
        if (root.right != null) {
            helper(root.right, pre);
        }
    }

 /*   public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode cur = pRootOfTree;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                cur.left = findMax(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                cur.right = findMin(cur.right);
            }
        }
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static TreeNode findMax(TreeNode root) {
        TreeNode cur = root;
        if (cur.right != null) {
            while (cur.right != null) {
                cur = cur.right;
            }
            return cur;
        } else {
            return cur;
        }
    }

    private static TreeNode findMin(TreeNode root) {
        TreeNode cur = root;
        if (cur.left != null) {
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            return cur;
        }
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        printTree(root);

        //System.out.println(findMin(root).val);
       // System.out.println(findMax(root).val);

        TreeNode head = Convert(root);
        printDoubleTreeNode(head);
        System.out.println(head.val);
        while (head != null) {
            System.out.println(head.left + " " + head.right);
            head = head.right;
        }
    }
}
