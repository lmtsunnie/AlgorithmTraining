package tree;

/*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
  如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/

public class IsPosTraversalSequenceOfBSTOrNot {
    /*BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
      如果去掉最后一个元素的序列为T，那么T满足：
      T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
      且这两段（子树）都是合法的后序序列。完美的递归定义。*/
    public static boolean isPosTraversalSequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1) return false;
        return isPos(sequence, 0, sequence.length - 1);
    }

    public static boolean isPos(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int i = start;
        // 如果是后序序列则start~i-1为小于sequence[end]的数，i~end-1为大于sequence[end]的数
        while (i < end && sequence[i] < sequence[end]) {
            i++;
        }
        // 验证i~end-1为大于sequence[end]的数
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end])
                return false;
        }
        return isPos(sequence, start, i - 1) && isPos(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{7,4,6,5};
        System.out.println(isPosTraversalSequenceOfBST(sequence));
    }

}

