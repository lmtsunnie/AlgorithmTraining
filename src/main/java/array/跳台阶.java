package array;

public class 跳台阶 {
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/

    /**
     * f(n) = f(n - 1) + f(n - 2)
     * f(1) = 1, f(2) = 2
     * 斐波那契数列，时间复杂度O(n)，空间复杂度O(1)
     */
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= target; i ++) {
            cur += pre;
            pre = cur - pre;
        }
        return cur;
    }
}
