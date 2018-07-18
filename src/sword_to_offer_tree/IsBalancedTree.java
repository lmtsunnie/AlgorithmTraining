package sword_to_offer_tree;

public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData {
        public boolean isBalanced;
        public int height;

        public ReturnData(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnData process(Node head) {
        if (head == null)
            return new ReturnData(true, 0);
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);
        if (!leftData.isBalanced || !rightData.isBalanced || Math.abs(rightData.height - leftData.height) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);
    }

    public static boolean isBalancedTree(Node head) {
        return process(head).isBalanced;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalancedTree(head));

    }
}
