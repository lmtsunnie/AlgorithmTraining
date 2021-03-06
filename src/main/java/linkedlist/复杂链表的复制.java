package linkedlist;

import common.RandomListNode;

public class 复杂链表的复制 {
    /*输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/

    /**
     * 讨论区：
     * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
     * 2、遍历链表，A1->random = A->random->next;
     * 3、将链表拆分成原链表和复制后的链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode curCopy;
        // 复制每个节点
        while (cur != null) {
            curCopy = new RandomListNode(cur.val);
            // cur -2-> curCopy -1-> cur.next
            curCopy.next = cur.next;
            cur.next = curCopy;
            cur = cur.next.next;
        }
        // 复制random指针
        cur = pHead;
        while (cur != null) {
            curCopy = cur.next;
            if (cur.random != null) {
                curCopy.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分，改变next指针
        RandomListNode headCopy = pHead.next;
        RandomListNode tmp;
        cur = pHead;
        while (cur.next != null) {
            // cur -> curCopy -> cur.next -> curCopy.next
            // cur -> tmp -> cur.next
            tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return headCopy;
    }
}





