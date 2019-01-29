package array;

import static common.PrintMatrix.printMatrix;

public class leetcode64MinimumPathSum {
    /*Given a m x n grid filled with non-negative numbers,
    find a path from top left to bottom right
    which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/
    /*=====================================================================================*/
    /*自想1：动态规划背包问题：
     * m行n列的矩阵
     * 仅用一列来记录
     * 时间复杂度O(n²)，空间复杂度O(n)
     * */
    public static int minimumPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] curCol = new int[m]; // m为行数，即一列的个数
        // 第0列,j = 0
        curCol[0] = matrix[0][0];
        for (int i = 1; i < m; i ++) {
            curCol[i] = curCol[i - 1] + matrix[i][0];
        }
        for (int j = 1; j < n; j ++) {
            curCol[0] += matrix[0][j];
            for (int i = 1; i < m; i ++) { // 第i行第j列
                curCol[i] = matrix[i][j] + Math.min(curCol[i], curCol[i - 1]);
            }
        }
        return curCol[m - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        printMatrix(matrix);
        System.out.println(minimumPathSum(matrix));
        System.out.println("============");
        int[][] matrix2 = new int[][]{{1,3,1,4}, {1,5,1,6}, {4,2,1,3}};
        printMatrix(matrix2);
        System.out.println(minimumPathSum(matrix2));
    }
}
