package sword_to_offer_linkedlist;

import java.util.HashSet;

public class LinkedListHasLoopOrNot {
    // 判断链表是否有环,如果有环则返回第一个入环的节点，如果无环则返回空
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 1、head作为key放入hashset，只有key，没有value，空间复杂度O(n)
    public static Node getLoopNode1(Node head) {
        if (head == null) return null;
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // 2、不使用辅助空间
    // 快指针一次走两步，慢指针一次走一步，如果快指针遇到空则返回无环
    // 如果有环则快指针和慢指针一定会相遇，相遇后快指针回到开头，以后快指针和慢指针都一次走一步，相遇处即为入环节点
    public static Node getLoopNode2(Node head) {
        if (head == null) return null;
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->4...
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        if (getLoopNode2(head1) == null) {
            System.out.println("The LinkedList doesn't have loop");
        } else {
            System.out.println("The value of first loop node is " + getLoopNode2(head1).value);
        }
        // 1->2->3->4->5->6->7->null
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);
        head2.next.next.next.next.next.next = new Node(7);
        if (getLoopNode2(head2) == null) {
            System.out.println("The LinkedList doesn't have loop");
        } else {
            System.out.println("The value of first loop node is " + getLoopNode2(head2).value);
        }
    }
}