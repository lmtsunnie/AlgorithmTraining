package linkedlist;

public class ChangeDuplicateNodeToOnceInSortedLinkedList {
    public static class Node {
        int value;
        Node next = null;

        Node(int value) {
            this.value = value;
        }
    }

    public static Node changeDuplicateNodeToOnce(Node head) {
        if (head == null) return null;
        Node cur = head.next; // 当前节点
        Node preNode = head; // 当前节点的前一个节点
        while (cur != null) {
            // 比较我和我的前一个数是否相等
            if (cur.value == preNode.value) {
                // 如果相等，删除前一个节点(把要删除的节点的下一个节点的值赋给这个要删除的节点的位置，再让当前节点指向.next.next)
                preNode.value = preNode.next.value;
                preNode.next = preNode.next.next;
                cur = cur.next;
                continue;
            }
            preNode = cur; // 当前节点作为下一轮的前一个节点
            cur = cur.next; // 当前节点的下一个节点作为下一轮的当前节点
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        if (head == null) return;
        //System.out.print("Linked List: ");
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(4);
        head.next = node1;
        head.next.next = node2;
        head.next.next.next = node3;
        head.next.next.next.next = node4;
        head.next.next.next.next.next = node5;
        head.next.next.next.next.next.next = node6;
        System.out.println("删除重复节点前：");
        printLinkedList(head);
        System.out.println("删除重复节点后：");
        printLinkedList(changeDuplicateNodeToOnce(head));
    }
}

