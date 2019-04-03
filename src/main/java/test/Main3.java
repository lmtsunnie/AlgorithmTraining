package test;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(count(m, n, k));
        }
    }

    public static int count(int m, int n, int k) {
        int[][] flag = new int[m][n];
        return helper(0, 0, m, n, flag, k);
    }

    public static int helper(int i, int j, int m, int n, int[][] flag, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || sum(i) + sum(j) > k || flag[i][j] == 1) {
            return 0;
        }
        flag[i][j] = 1;
        return helper(i - 1, j, m, n, flag, k)
                + helper(i + 1, j, m, n, flag, k)
                + helper(i, j - 1, m, n, flag, k)
                + helper(i, j + 1, m, n, flag, k)
                + 1;
    }
    public static int sum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }
}  /*public static int count(int m, int n, int k) {
        if (k <= 0) {
            return 0;
        }
        Stack<Integer> stackX = new Stack<>();
        Stack<Integer> stackY = new Stack<>();
        boolean[][] flag = new boolean[m][n];
        stackX.push(0);
        stackY.push(0);
        int count = 0;
        int x = 0;
        int y = 0;
        flag[0][0] = true;
        while (stackX.size() != 0 && stackY.size() != 0) {
            x = stackX.peek();
            y = stackY.peek();
            if ((x - 1) >= 0 && !flag[x - 1][y] && check(x - 1, y, k)) {
                stackX.add(x - 1);
                stackY.add(y);
                flag[x - 1][y] = true;
                continue;
            }
            if ((x + 1) < m && !flag[x + 1][y] && check(x + 1, y, k)) {
                stackX.add(x + 1);
                stackY.add(y);
                flag[x + 1][y] = true;
                continue;
            }
            if ((y - 1) >= 0 && !flag[x][y - 1] && check(x, y - 1, k)) {
                stackX.add(x);
                stackY.add(y - 1);
                flag[x][y - 1] = true;
                continue;
            }
            if ((y + 1) < n && !flag[x][y + 1] && check(x, y + 1, k)) {
                stackX.add(x);
                stackY.add(y + 1);
                flag[x][y + 1] = true;
                continue;
            }
            stackX.pop();
            stackY.pop();
            count++;
        }
        return count;
    }

    public static boolean check(int m, int n, int k) {
        int tmp = 0;
        while (m > 0) {
            tmp += m % 10;
            m /= 10;
        }
        while (n > 0) {
            tmp += n % 10;
            n /= 10;
        }
        return tmp <= k;
    }*/

