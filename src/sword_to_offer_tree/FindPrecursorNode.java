package sword_to_offer_tree;

public class FindPrecursorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    // 若有左子树，则为左子树上最右的节点；若没有左子树，则为第一个满足某种要求的父节点，要求是我在该父节点的右子树上
    public static Node findPrecursorNode(Node head) {
        if (head == null) return head;
        if (head.left != null) return findRightMost(head.left);
        else return findFatherWhichIamInHisRight(head);
    }
    public static Node findRightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static Node findFatherWhichIamInHisRight(Node node) {
        while (node.parent != null && node.parent.right != node)
            node = node.parent;
        return node.parent;
    }
    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.right.right; // 10
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.right; // 9
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.right.left; // 8
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.right.left.left; // 7
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head; // 6
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.left.right.right; // 5
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.left.right; // 4
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.left; // 3
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.left.left.right; // 2
        System.out.println(test.value + " previous: " + findPrecursorNode(test).value);
        test = head.left.left; // 1's previous is null
        System.out.println(test.value + " previous: " + findPrecursorNode(test));
    }



}
