package linkedlist;

public class PrintCommonPartBetweenTwoSortedLinkedList {
    // 打印两个有序链表的公共部分
    // 思路：外排
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printCommonPartBetweenTwoSortedLinkedList(Node head1, Node head2) {
        System.out.print("Common Part: ");
        // 谁小跳过谁
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else { // head1.value == head2.value
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
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

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(6);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(8);

        printLinkedList(head1);
        printLinkedList(head2);
        printCommonPartBetweenTwoSortedLinkedList(head1, head2);
    }

}
