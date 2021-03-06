package tree;

public class 二叉搜索树的后序遍历序列 {
    /*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/

    /**
     * 讨论区：
     * 利用二叉搜索树的性质（左边<中间<右边）和后序遍历（左、右、根）的特点
     * sequence序列分为三部分[比根小 | 比根大 | 根]
     * 递归求解 T(n) = 2T(n/2) + O(n)
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public boolean helper(int[] sequence, int lo, int hi) {
        if (lo >= hi) {
            return true;
        }
        int i = hi - 1;
        // 从最后一个数往前，找到第一个比根小的数
        while (i >= lo && sequence[i] > sequence[hi]) {
            i--;
        }
        // 如果在比根小的部分找到比根大的数，则返回false
        for (int j = i; j >= lo; j--) {
            if (sequence[j] > sequence[hi]) {
                return false;
            }
        }
        return helper(sequence, lo, i) && helper(sequence, i + 1, hi - 1);
    }

    public boolean VerifySquenceOfBST1(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return helper(sequence, 0, sequence.length - 1);
    }

    /**
     * 讨论区：
     * 非递归，可以暂时把[左子树 | 右子树 | 根]去掉根之后=[左子树 | 右子树其他 | 右子树的根]
     * =[左子树 | 右子树的左子树 | 右子树的右子树 | 右子树的根]
     * 因为左子树肯定<右子树的根，所以可以把左子树并入右子树的左子树中看待
     * 当i--不断减小，会开始单独验证左子树
     * 时间复杂度O(n²)，空间复杂度O(1)
     */
    public boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int i = 0, lastIndex = sequence.length - 1;
        while (lastIndex >= 0) {
            while (sequence[i] < sequence[lastIndex]) {
                i++;
            }
            while (sequence[i] > sequence[lastIndex]) {
                i++;
            }
            // 正常情况下退出前最后一次i = lastIndex - 1，i++后i=lastIndex
            // while(sequence[lastIndex] > sequence[lastIndex])不成立则退出
            if (i != lastIndex) {
                return false;
            }
            i = 0;
            lastIndex--;
        }
        return true;
    }
}
