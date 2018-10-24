package linkedlist;

public class DeleteDuplicateNodeInSortedLinkedList {
    public static class Node {
        int value;
        Node next = null;

        Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteDuplicateNode(Node head) {
        if (head == null) return null;
        Node pre = null; // 当前节点的前一个节点
        Node cur = head; // 当前节点
        while (cur != null) {
            Node pos = cur.next;
            boolean needDelete = false;
            // 如果我和后一个节点的值相等，则将我标志为需要删除
            if (pos != null && cur.value == pos.value) {
                needDelete = true;
            }
            if (!needDelete) { // 如果不需要删除我
                pre = cur;
                cur = cur.next;
            } else { // 如果需要删除我，则找到所有相等的值都删除，将pre指向第一个不重复的值pos
                int dupValue = cur.value;
                while (cur != null && cur.value == dupValue) {
                    cur = cur.next;
                    pos = cur;
                } // 跳出循环的条件是找到了第一个cur后面不重复的值pos，或者直到找到最后一个值都没找到不重复的值
                if (pre == null) { // 如果删除的节点是头结点
                    head = pos; // 则把pos作为头结点
                } else {
                    pre.next = pos; // 否则将pos接上pre
                }
                cur = pos; // pos作为下一个cur
            }
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        if (head == null) return;
        //System.out.Print("Linked List: ");
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(3);
        //ListNode node7 = new ListNode(4);
        head.next = node1;
        head.next.next = node2;
        head.next.next.next = node3;
        head.next.next.next.next = node4;
        head.next.next.next.next.next = node5;
        head.next.next.next.next.next.next = node6;
        //head.next.next.next.next.next.next.next = node7;

        System.out.println("删除重复节点前：");
        printLinkedList(head);
        System.out.println("删除重复节点后：");
        printLinkedList(deleteDuplicateNode(head));
    }
}

