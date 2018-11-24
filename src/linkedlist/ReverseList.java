package linkedlist;

public class ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next; // 把下一个节点存储起来
            cur.next = pre; // 把当前节点的指针指向前一个节点
            pre = cur; // 把当前节点作为下一个节点的前一个节点
            cur = next; // 把刚刚存储好的下一个节点作为当前节点
        }
        return pre;
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next; // 把下一个节点存储起来
            head.next = pre; // 把当前节点的next指针指向前一个节点
            head.last = next;   // 把当前节点的last指针指向下一个节点
            pre = head; // 把当前节点作为下一个节点的前一个节点
            head = next; // 把刚刚存储好的下一个节点作为当前节点
        }
        return pre;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        System.out.print("head to end: ");
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print(" | ");
        System.out.print("end to head: ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        System.out.println("Before reverse: ");
        printLinkedList(head1);
        System.out.println("After reverse: ");
        printLinkedList(reverseList(head1));
        System.out.println("Original LinkedList after modify：");
        printLinkedList(head1);

        System.out.println("========================================");

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        System.out.println("Before reverse: ");
        printDoubleLinkedList(head2);
        System.out.println("After reverse: ");
        printDoubleLinkedList(reverseList(head2));
        System.out.println("Original LinkedList after modify：");
        printDoubleLinkedList(head2);

    }
}
