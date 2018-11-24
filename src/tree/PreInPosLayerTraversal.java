package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreInPosLayerTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

/*=====================================================================================*/
    // 对左子树进行中序遍历，打印自己，对右子树进行中序遍历
    public static void preOrderRecur(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    // 用栈实现，弹出一个节点作为当前节点，打印当前节点，
    // 然后对于当前节点有右先压右，有左后压左。
    // 先压右后压左，弹出为先弹左后弹右
    public static void preOrderUnrecur(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur;
        while (!stack.empty()) {
            cur = stack.pop();
            // 先打印自己
            System.out.print(cur.value + " ");
            // 有右先压右
            if (cur.right != null)
                stack.push(cur.right);
            // 有左后压左
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

/*=====================================================================================*/
    // 对左子树进行中序遍历，打印自己，对右子树进行中序遍历
    public static void inOrderRecur(Node root) {
        if (root == null) return;
        inOrderRecur(root.left);
        System.out.print(root.value + " ");
        inOrderRecur(root.right);
    }

    // 用栈实现，当前节点不为空或者栈不为空继续while（只有当前节点为空，栈也为空才退出循环）：
    // 当前节点不为空，当前节点压入栈，当前节点往左跑（左边界一压压一溜）；
    // 当前节点为空，从栈中拿一个打印，当前节点向右跑
    public static void inOrderUnrecur(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) { // 当前节点不为空
                stack.push(cur);
                cur = cur.left;
            } else { // 当前节点为空，栈不为空
                cur = stack.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }

/*=====================================================================================*/
    // 先对左子树进行后序遍历，再对右子树进行后序遍历，再打印自己
    public static void posOrderRecur(Node root) {
        if (root == null) return;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.value + " ");
    }

    // 后序：左-右-中，通过 中-左-右
    // (回顾先序：用栈实现，弹出一个节点作为当前节点，打印当前节点，
    // 然后对于当前节点有右先压右，有左后压左。
    // 先压右后压左，弹出为先弹左后弹右)
    // 对于先序左右互换得到中-右-左，
    // 打印的时候不打印，存到栈里去，
    // 存完把所有栈中的元素打印 -> 左-右-中
    public static void posOrderUnrecur(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> storeStack = new Stack<>();
        stack.push(root);
        Node cur;
        while (!stack.empty()) {
            cur = stack.pop();
            storeStack.push(cur.value);
            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }
        while (!storeStack.empty()) {
            System.out.print(storeStack.pop() + " ");
        }
    }

/*=====================================================================================*/
    // 先进先出，用队列实现。弹一个出来，把左边右边加进去
    // bfs的思想
    public static void layerTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

/*=====================================================================================*/
    // Print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
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

/*=====================================================================================*/
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        printTree(head);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        preOrderUnrecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderUnrecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderUnrecur(head);
        System.out.println();

        // layer
        System.out.println("============layer=============");
        layerTraversal(head);
    }
}
