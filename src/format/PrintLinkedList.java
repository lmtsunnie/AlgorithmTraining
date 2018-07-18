package format;

public class PrintLinkedList {
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

    public static void printLinkedList(Node head) {
        if (head == null) return;
        System.out.print("Linked List: ");
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println(head.value);
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        if (head == null) return;
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        System.out.print("head to end: ");
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print(head.value);
        end = head;
        System.out.print(" | ");
        System.out.print("end to head: ");
        while (end.last != null) {
            System.out.print(end.value + " -> ");
            end = end.last;
        }
        System.out.println(end.value);
    }



    public static void printLinkedList1(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void printDoubleLinkedList2(DoubleNode head) {
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
       // System.out.println("Before reverse: ");
        printLinkedList(head1);
        //System.out.println("After reverse: ");
       // printLinkedList(reverseList(head1));

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
