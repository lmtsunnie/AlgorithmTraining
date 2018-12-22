package linkedlist;

import java.util.Stack;

public class IsPalindromeLinkedList {
    // 判断一个链表是否为回文结构
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 方法1：用一个辅助栈，将链表中的元素和栈中逆序的元素一一比较，每一个值都相等则为回文结构，空间复杂度O(n)
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法2：快指针一次走两步，慢指针一次走一步，快指针走完慢指针来到几乎中点的位置
    // 慢指针之后走的压入栈中，实际上是把后半段逆序和前半段比较，空间复杂度O(n/2)
    public static boolean isPalindrome2(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next; // 考虑到奇偶数，应该把slow往后一步
        Node fast = head;
        // 奇数时慢指针来到中点的后一个位置，偶数时慢指针来到两个中点的后一个位置
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 方法3：完全不用辅助空间，空间复杂度O(1)
    // 快指针一次走两步，慢指针一次走一步，快指针走完慢指针来到几乎中点的位置
    // 把慢指针后面的后半部分逆序，再一个从尾部开始走，一个从头部开始走，遇到空的还没发现不同则是回文链表
    // 由于要保证原来的结构，故把后半部分逆序的再调整回去
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        // 奇数时慢指针来到中点位置，偶数时慢指针来到两个中点的前一个位置
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 记录中点的位置
        Node mid = slow;
        Node pre = null;
        Node cur = slow;
        // 把慢指针后面的后半部分逆序
        while (cur != null) {
            Node pos = cur.next; // 把当前节点的下一个节点记录下来
            cur.next = pre; // 把cur的next指向前一个节点
            pre = cur; // 把这一轮的当前节点作为下一轮的pre节点
            cur = pos; // 把这一轮的pos节点作为下一轮的当前节点
        } // 退出循环时cur为空，最后一个节点是pre逆序指向前面
        slow = pre;
        // slow和head同时开始走
        while (slow != null && head != null) {
            if (slow.value != head.value) {
                reverse(pre);
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        reverse(pre);
        return true;
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next; // 把下一个节点存储起来
            head.next = pre; // 把当前节点的指针指向前一个节点

            pre = head; // 把当前节点作为下一个节点的前一个节点
            head = next; // 把刚刚存储好的下一个节点作为当前节点
        }
        return pre;
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        System.out.println("Original LinkedList after isPalindrome3:");
        printLinkedList(head);
        System.out.println("=========================");
    }

}
