package tree;

import java.util.Stack;

public class IsBSTReuseInorderTraversalUnRecur {
    // 复用非递归的中序遍历的函数
    // 二叉树中序遍历的结果是依次升序的 <=> 该二叉树是一棵搜索二叉树
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // 用栈实现，当前节点不为空或者栈不为空继续：当前节点不为空，当前节点压入栈，当前节点往左跑（左边界一压压一溜）；当前节点为空，从栈中拿一个打印，当前节点向右跑
    public static boolean isBST(Node head) {
        if (head == null) return true;
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                //System.out.Print(head.val + " ");
                if (head.value > pre) {
                    pre = head.value;
                } else {
                    return false;
                }
                head = head.right;
            }
        }
        //System.out.println();
        return true;
    }

    // for LinkedListHasLoopOrNot -- Print tree
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
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
    }
}
