package common;

public class PrintLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static class DoubleNode {
        public int val;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.val = data;
            this.next = null;
            this.last = null;
        }
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) return;
        System.out.print("Linked List: ");
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        if (head == null) {
            return;
        }
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        System.out.print("head to end: ");
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print(head.val);
        end = head;
        System.out.print(" | ");
        System.out.print("end to head: ");
        while (end.last != null) {
            System.out.print(end.val + " -> ");
            end = end.last;
        }
        System.out.println(end.val);
    }

    public static void printDoubleTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("Double Linked List: ");
        TreeNode end = null;
        System.out.print("root to end: ");
        while (root.right != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.print(root.val);
        end = root;
        System.out.print(" | ");
        System.out.print("end to root: ");
        while (end.left != null) {
            System.out.print(end.val + " -> ");
            end = end.left;
        }
        System.out.println(end.val);
    }

    public static void printLinkedList1(ListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void printDoubleLinkedList2(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        System.out.print("head to end: ");
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.next;
        }
        System.out.print(" | ");
        System.out.print("end to head: ");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
       // System.out.println("Before reverse: ");
        printLinkedList(head1);
        //System.out.println("After reverse: ");
       // PrintLinkedList(reverseList(head1));

        System.out.println("========================================");

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        //System.out.println("Before reverse: ");
        printDoubleLinkedList(head2);
        //System.out.println("After reverse: ");
        //printDoubleLinkedList(reverseList(head2));

    }
}
