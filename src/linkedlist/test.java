package linkedlist;

import java.util.HashSet;

public class test {
    // 问题1、判断链表是否有环,如果有环则返回第一个入环的节点，如果无环则返回空
    // 问题2、判断两个链表是否相交，若相交则返回相交的第一个节点，若不相交则返回null
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

    // 2、O(1)，准备两个指针，快指针一次走两步，慢指针一次走一步
    // 如果快指针遇到空，返回无环
    // 如果快指针和慢指针相遇，快指针回到开头，以后快指针和慢指针都一次走一步，快指针和慢指针会在入环节点处相遇
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

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        // 两个链表都无环
        // 空间复杂度O(1)的方法：
        // 先遍历得到链表一和链表二的长度和最后一个节点，如果end1 != end2则不可能相交
        // end1 == end2，若链表1长度为100，链表2长度为80，则head1先走20，然后head1和head2一起走，相遇处即第一个相交节点处
        Node cur = head1;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        Node end1 = cur;
        cur = head2;
        while (cur.next != null) {
            cur = cur.next;
            count--;
        }
        Node end2 = cur;
        if (end1 != end2) return null;
        Node longer = count > 0 ? head1 : head2;
        Node shorter = longer == head1 ? head2 : head1;
        count = Math.abs(count);
        while (count > 0) {
            longer = longer.next;
            count--;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null 无环
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null 无环
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

       /* // 1->2->3->4->5->6->7->4...有环
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2 无环
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).val);

        // 0->9->8->6->4->5->6..有环
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val);*/

    }
}
