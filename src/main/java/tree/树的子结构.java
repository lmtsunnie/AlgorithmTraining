package tree;

import common.TreeNode;

public class 树的子结构 {
    /*输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）*/

    /**
     * 讨论区：
     * 理解题意：子结构可能是子树，也可能只是子树的一部分，但不能是空树
     * 递归的思路：root2是不是我的子结构，root2是不是我的左子树的子结构，root2是不是我的右子树的子结构
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSameStructure(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    public boolean isSameStructure(TreeNode subTreeRootA, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (subTreeRootA == null) {
            return false;
        }
        if (subTreeRootA.val != root2.val) {
            return false;
        }
        return isSameStructure(subTreeRootA.left, root2.left)
                && isSameStructure(subTreeRootA.right, root2.right);
    }
}
