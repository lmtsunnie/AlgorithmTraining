package matrix;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    /*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    1  2  3  4
    5  6  7  8
    9  10 11 12
    13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/

    /**
     * 讨论区：
     * 分为左->右，上->下，右->左，下->上四个过程，每结束一轮正方形向内缩小一圈
     * 注意加入条件判断防止出现单行或者单列的情况。
     * 时间复杂度O(n²)，空间复杂度O(1)
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return null;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 左->右（共n个）
            for (int col = colStart; col <= colEnd; col++) {
                res.add(matrix[rowStart][col]);
            }
            // 上->下（共n-1个）
            for (int row = rowStart + 1; row <= rowEnd; row++) {
                res.add(matrix[row][colEnd]);
            }
            // 右->左（共n-1个），去除单列
            if (rowStart != rowEnd) {
                for (int col = colEnd - 1; col >= colStart; col--) {
                    res.add(matrix[rowEnd][col]);
                }
            }
            // 下->上
            if (colStart != colEnd) {
                for (int row = rowEnd - 1; row >= rowStart + 1; row--) {
                    res.add(matrix[row][colStart]);
                }
            }
            // 每结束一轮正方形向内缩小一圈
            colStart ++;
            colEnd --;
            rowStart ++;
            rowEnd --;
        }
        return res;
    }
}
