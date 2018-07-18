package sword_to_offer_linkedlist;

import java.util.HashMap;

public class CopyLinkedListWithRandomPointer {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    // 用HashMap，K-原链表，V-拷贝后的链表，空间复杂度：O(n)
    public static Node copyLinkedListWithRandomPointer1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    // 空间复杂度：O(1)
    public static Node copyLinkedListWithRandomPointer2(Node head) {
        if (head == null) return null;

        Node cur = head;
        Node next = null;
        // 将每一个的复制节点（只含值）放在该节点的后面
        while (cur != null) {
            next = cur.next; // 原有链表的下一个节点
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
        // 为每一个复制节点指定rand指针
        while (cur != null) {
            curCopy = cur.next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }

        Node res = head.next;
        cur = head;
        // 分割成两个链表
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = cur.next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("Original LinkedList:");
        printRandLinkedList(head);
        System.out.println("Copy LinkedList:");
        Node res1 = copyLinkedListWithRandomPointer1(head);
        printRandLinkedList(res1);
        System.out.println("Original LinkedList After Copy");
        printRandLinkedList(head);
        System.out.println("=============================");

        System.out.println("Original LinkedList:");
        printRandLinkedList(head);
        Node res2 = copyLinkedListWithRandomPointer2(head);
        System.out.println("Copy LinkedList:");
        printRandLinkedList(res2);
        System.out.println("Original LinkedList After Copy");
        printRandLinkedList(head);
    }
}
