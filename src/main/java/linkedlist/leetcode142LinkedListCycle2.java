package linkedlist;

public class leetcode142LinkedListCycle2 {
    /*Given a linked list, return the node where the cycle begins.
    If there is no cycle, return null.

Note: Do not modify the linked list.
Follow up:
Can you solve it without using extra space?*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 快指针一次走两步，慢指针一次走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 快指针回到起点，快指针和慢指针都一次走一步
        fast = head;
        while (fast != null && slow != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        //ListNode node3 = new ListNode(4);
        node2.next = node1;
        //ListNode node4 = new ListNode(2);
        //node3.next = node4;
        //node4.next = node2;

        System.out.println(detectCycle(node1).val);
    }
}
