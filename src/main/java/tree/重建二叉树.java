package tree;

import common.TreeNode;

public class 重建二叉树 {
    /*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/

    /**
     * 自想1：
     * pre[]中pre[preStart]是root，在in[]中找到in[inIndex]=root
     * 左子树 pre[preStart + 1]~pre[inIndex - inStart + preStart] <- in[inStart]~in[inIndex - 1]
     * 右子树 pre[inIndex - inStart + preStart + 1]~pre[preEnd] <- in[inIndex + 1]~in[inEnd]
     * T(n) = 2T(n/2) + O(n)，时间复杂度O(nlogn)
     * 树高=递归深度=O(logn)，空间复杂度O(logn)
     */
    public TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        // 结束条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int inIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        // 基于当前情况做深度搜索(一步步走到底)
        root.left = helper(pre, preStart + 1, inIndex - inStart + preStart, in, inStart, inIndex - 1);
        root.right = helper(pre, inIndex - inStart + preStart + 1, preEnd, in, inIndex + 1, inEnd);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
}
