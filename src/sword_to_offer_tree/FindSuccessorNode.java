package sword_to_offer_tree;

// 后继节点，即中序遍历中的下一个节点
public class FindSuccessorNode {
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

        Node test = head.left.left;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + findSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + findSuccessorNode(test));
    }



}
