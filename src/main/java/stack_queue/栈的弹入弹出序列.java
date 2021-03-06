package stack_queue;

import java.util.ArrayList;

public class 栈的弹入弹出序列 {
    /*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
    序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
    （注意：这两个序列的长度是相等的）*/

    /**
     * 讨论区：
     * 用一个辅助的数列，存储栈的压入过程
     * i存储pushA的下标，j存储popA的下标
     * 时间复杂度O(n²)，空间复杂度O(n)
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length <= 0 || popA == null || pushA.length != popA.length) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0, j = 0; i < pushA.length && j < popA.length; ) {
            arrayList.add(pushA[i++]);
            while (j < popA.length && arrayList.get(arrayList.size() - 1).equals(popA[j])) {
                arrayList.remove(arrayList.size() - 1);
                j++;
            }
        }
        return arrayList.isEmpty();
    }
}
