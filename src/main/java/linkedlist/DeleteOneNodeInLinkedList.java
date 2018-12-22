package linkedlist;

public class DeleteOneNodeInLinkedList {
    public static class Node {
        int value;
        Node next = null;
        Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteOneNode(Node head, Node toBeDeleted) {
        // 如果head或者toBeDeleted为null，返回head
        if (head == null | toBeDeleted == null) return head;
        // 如果即将删除的节点是最后一个节点
        if (toBeDeleted.next == null) {
            // 如果即将删除的节点既是最后一个节点也是第一个节点，即只有一个节点时
            if (head == toBeDeleted) {
                head = null; // head被覆盖了，指向null
                return head;
            } else { // 如果只是最后一个节点而不是第一个节点，即链表至少有两个节点，toBeDeleted有前一个节点，使用遍历将前一个节点的next指针指向null
                Node cur = head;
                while (cur.next != toBeDeleted) {
                    cur = cur.next;
                }
                cur.next = null;
                return head;
            }
        }
        toBeDeleted.value = toBeDeleted.next.value;
        toBeDeleted.next = toBeDeleted.next.next;
        return head;
}

    public static void printLinkedList(Node head) {
        if (head == null) return;
        Node pNode = head;
        while (pNode.next != null) {
            System.out.print(pNode.value + "->");
            pNode = pNode.next;
        }
        System.out.println(pNode.value);
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        /*ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;*/
        System.out.println("删除节点之前：");
        printLinkedList(head);
        deleteOneNode(head, head);
        System.out.println("删除节点之后：");
        printLinkedList(head);

        System.out.println("============================");

        Node head1 = new Node(1);
       /* ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        head1.next = node11;
        node11.next = node12;*/
        System.out.println("删除节点之前：");
        printLinkedList(head1);
        System.out.println("带返回值删除节点之后：");
        printLinkedList(deleteOneNode(head1, head1));
    }
}
