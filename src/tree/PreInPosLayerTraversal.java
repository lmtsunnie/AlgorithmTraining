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

    public static void preOrderRecur(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    // 用栈实现，弹出当前节点，有右先压右，有左后压左
    // 先压右后压左，弹出为先弹左后弹右
    public static void preOrderUnRecur(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            // 有右先压右
            if (head.right != null) {
                stack.push(head.right);
            }
            // 有左后压左
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        System.out.println();
    }

    // 用栈实现，当前节点不为空或者栈不为空继续：当前节点不为空，当前节点压入栈，当前节点往左跑（左边界一压压一溜）；当前节点为空，从栈中拿一个打印，当前节点向右跑
    public static void inOrderUnRecur(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    // 后序：左-右-中
    // 通过 中-左-右(先序) -> 中-右-左，打印的时候不打印，存到栈里去，存完把所有栈中的元素打印 -> 左-右-中
    public static void posOrderUnRecur(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> printStack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            // System.out.print(head.value + " ");
            printStack.push(head.value);
            // 有左先压左
            if (head.left != null) {
                stack.push(head.left);
            }
            // 有右后压右
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!printStack.isEmpty()) {
            System.out.print(printStack.pop() + " ");
        }
        System.out.println();
    }

    // 弹一个出来，把左边右边加进去
    public static void layerTraversal(Node head) {
        if (head == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
    }

    // for LinkedListHasLoopOrNot -- print tree
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
        preOrderUnRecur(head);
        System.out.print("in-order: ");
        inOrderUnRecur(head);
        System.out.print("pos-order: ");
        posOrderUnRecur(head);

        // layer
        System.out.println("============layer=============");
        layerTraversal(head);
    }
}
