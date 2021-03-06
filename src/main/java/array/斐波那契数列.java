package array;

public class 斐波那契数列 {
    /*大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39*/

    /**
     * 递归从后算到前时间复杂度O(2的n次方)
     * 要利用动态规划从前算到后，利用每一个前面已经算过的结果
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int pre = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            cur += pre;
            // 即上一个cur
            pre = cur - pre;
        }
        return cur;
    }
}
