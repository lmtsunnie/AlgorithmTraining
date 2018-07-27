package linkedlist;

import java.util.HashSet;

// 问题1、判断链表是否有环,如果有环则返回第一个入环的节点，如果无环则返回空
// 问题2、判断两个链表是否相交，若相交则返回相交的第一个节点，若不相交则返回null
public class FindFirstIntersectNodeBetweenTwoLinkedList {

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

    // 找到第一个相交的节点
    // 1、判断两个无环单链表是否相交：
    // （1） O(n)：链表一的节点都放到map里，遍历链表二，第一个在map中的节点为相交节点，如果遍历到空都没找到在map中的则不相交
    // （2） O(1)：先遍历链表一和链表二，统计链表一、二的长度和链表一、二的最后一个节点
    //            如果end1 != end2，链表一和链表二不可能相交
    //            如果end1 == end2，长度一100和长度二80比较，head1先走20步，然后head1和head2一起走，他们一定会共同走到第一个相交的节点处
    // 2、一个有环一个无环的单链表，不可能相交
    // 3、两个有环的单链表：三种情况
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        // loop1为链表1的入环节点
        // loop2为链表2的入环节点
        Node loop1 = getLoopNode2(head1);
        Node loop2 = getLoopNode2(head2);

        // 两个链表都无环
        if (loop1 == null && loop2 == null) {
            return noLoop2(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    private static Node noLoop1(Node head1, Node head2) {
        // 空间复杂度O(n)的方法：
        // 将链表1的节点都放入HashSet中，遍历链表2，
        // 找到的第一个在HashSet中存在的节点为相交节点，如果遍历到空都没在HashSet中找到则不相交
        HashSet<Node> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    private static Node noLoop2(Node head1, Node head2) {
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

    private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        if (loop1 == loop2) {
            return bothLoopCase2(head1, head2, loop1);
        }

        Node cur1 = loop1;
        while (cur1 != null) {
            if (cur1 == loop2) {
                return loop1; // case3
            }
            cur1 = cur1.next;
        }
        return null; // case1
    }

    // 此情况下等同于无环链表相交
    private static Node bothLoopCase2(Node head1, Node head2, Node loop) {
        Node cur = head1;
        int count = 0;
        while (cur.next != loop) {
            cur = cur.next;
            count++;
        }
        Node end1 = cur;
        cur = head2;
        while (cur.next != loop) {
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
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
