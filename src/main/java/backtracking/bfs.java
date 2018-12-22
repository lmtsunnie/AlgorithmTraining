package backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    /* matrix为n*n邻接矩阵：
    * matrix[i][j]为1表示有从i到j的有向边
    * 为0表示没有从i到j的有向边
    * */
    public static void main(String[] args) {
        // 1,2,3,4,5 五个节点
        int[][] matrix = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0}
                };
        bfs(matrix);
    }

    public static void bfs(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length;
        boolean[] visited = new boolean[n]; // 全部会初始化为false
        for (int i = 0; i < n; i ++) {
            if (visited[i]) continue;
            helper(matrix, visited, i);
        }
    }

    public static void helper(int[][] matrix, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            System.out.println((pop + 1) + " ");
            for (int i = 0; i < matrix.length; i ++) {
                if (!visited[i] && matrix[pop][i] == 1) {
                    visited[i] = true; // visited表示第i号节点(i+1)是否已经入队
                    queue.add(i);
                }
            }
        }
    }
}
