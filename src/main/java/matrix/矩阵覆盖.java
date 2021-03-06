package matrix;

public class 矩阵覆盖 {
    /*我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/

    /**
     * f(n) = 前面n-1块与最后一块无连接 + 前面n-1块与最后一块有连接
     * = f(n - 1) * 1 + f(n - 2) * 1
     * f(0) = 0, f(1) = 1, f(2) = 2, f(3) = 3, ...
     * 斐波那契数列，时间复杂度O(n)，空间复杂度O(1)
     */
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= target; i++) {
            cur += pre;
            pre = cur - pre;
        }
        return cur;
    }
}
