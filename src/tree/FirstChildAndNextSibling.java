package tree;

import java.util.HashMap;

/*
树的长子-兄弟链表示法是树的一种二叉树表示法，它的每个结点的度d为2，是最节省存储空间的树的存储表示。
它的结点可以定义为
typedef struct CSNode{
	DataType data;
	struct CSNode* firstChild;
	struct CSNode* nextSibling;
}CSNode, *CSTree;

这种表示适用于频繁查找子女的应用，其查找子女的时间复杂度为O(d)，d为结点的度数。

已知一棵树的层次序列以及每个结点的度，试编写一个算法构造此树的长子-兄弟链表示法。
void create(CSTree &RT, DataType elem[], int deg[], int n)
{

}

其中n为结点个数，elem[i]中的结点对应的度对deg[i]。
*/


// 先用HashMap存储<index, TreeNode>,再逐一遍历建立联系，每个节点遍历一次，时间复杂度O(n)，额外空间复杂度O(n)
public class FirstChildAndNextSibling {
    public static class TreeNode {
        public int value;
        public TreeNode firstChild;
        public TreeNode nextSibling;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode create(int[] elem, int[] deg, int n) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < elem.length; i++) {
            map.put(i, new TreeNode(elem[i]));
        }
        TreeNode root = map.get(0);
        TreeNode curRoot = root; // 当前作为根的节点,cur的父节点
        TreeNode cur = null; // curRoot的下一层的某一个节点为当前节点
        TreeNode pre = null; // 与cur同层的左边一个节点
        int curIndex = 1; // cur的index, map.get(curIndex)即cur
        int curRootIndex = 0; // curRoot节点在elem[]中的index, map.get(curRootIndex)即curRoot
        int curLayerCount = deg[0]; // cur层的节点的总个数

        while (true) {
            for (int i = 1; i <= curLayerCount; i++) {
                // 建立cur节点
                cur = map.get(curIndex);
                // 建立两个指针
                if (i == 1) curRoot.firstChild = cur;
                if (pre != null) pre.nextSibling = cur;
                pre = cur;
                curIndex++;
            }
            // curRootIndex最大 = elem.length - 1
            if (curRootIndex == elem.length - 1) break;
            curRootIndex++;
            curRoot = map.get(curRootIndex);
            curLayerCount = deg[curRootIndex];
        }
        return root;
    }

    public static void main(String[] args) {
        int[] elem = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] deg = new int[]{4, 2, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0};
        TreeNode root = create(elem, deg, 13);
        System.out.println(root.value);
        System.out.println(root.firstChild.value + " " + root.firstChild.nextSibling.value + " "
                + root.firstChild.nextSibling.nextSibling.value + " " + root.firstChild.nextSibling.nextSibling.nextSibling.value);
        TreeNode thirdRoot = root.firstChild.firstChild;
        System.out.println(thirdRoot.value + " "
                + thirdRoot.nextSibling.value + " "
                + thirdRoot.nextSibling.nextSibling.value + " "
        + thirdRoot.nextSibling.nextSibling.nextSibling.value + " "
        + thirdRoot.nextSibling.nextSibling.nextSibling.nextSibling.value + " "
          + thirdRoot.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.value + " "
          + thirdRoot.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.value + " "
          + thirdRoot.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.value + " ");
    }
}
