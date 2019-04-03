package tree;

public class IsBSTReuseSuccessorNodeMethod {
    // 复用找到下一个节点的函数
    // 二叉树中序遍历的结果是依次升序的 <=> 该二叉树是一棵搜索二叉树
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    // 若有右子树，则为右子树上最左的节点；若没有右子树，则为第一个满足某种要求的父节点，要求是我在该父节点的左子树上
    public static Node findSuccessorNode(Node head) {
        if (head == null) return null;
        if (head.right != null) return findLeftMostNode(head.right);
        else return findFatherWhichIamInHisLeft(head);
    }

    public static Node findLeftMostNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node findFatherWhichIamInHisLeft(Node node) {
        Node parent = node.parent;
        while (parent != null) {
            if (parent.left == node) {
                return parent;
            } else {
                node = parent;
                parent = parent.parent;
            }
        }
        return parent;
    }

    public static boolean isBST(Node head) {
        Node successorNode = findSuccessorNode(head);
        while (head.value < successorNode.value && findSuccessorNode(successorNode) != null) {
            head = successorNode;
            successorNode = findSuccessorNode(head);
        }
        if (findSuccessorNode(successorNode) == null) return true;
        return false;
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
