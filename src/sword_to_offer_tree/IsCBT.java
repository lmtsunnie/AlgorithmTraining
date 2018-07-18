package sword_to_offer_tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 队列按层遍历
    // 1、有右孩子没有左孩子，一定不是完全二叉树
    // 2、左右孩子不双全：有左没右，或者左右都没有，（开启一个阶段）后面遇到的节点都必须是叶节点，否则不是完全二叉树
    // 若不违反1和2，则这棵树是完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leafStage = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            Node l = head.left;
            Node r = head.right;
            if ((r != null && l == null) || (leafStage && !(l == null && r == null))) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leafStage = true;
            }
        }
        return true;
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
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = null;
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isCBT(head));

    }
}
