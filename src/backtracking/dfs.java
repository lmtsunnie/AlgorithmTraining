package backtracking;

public class dfs {
    /* matrix为n*n邻接矩阵：
     * matrix[i][j]为1表示有从i到j的有向边
     * 为0表示没有从i到j的有向边
     * */
    public static void main(String[] args) {
        // 1,2,3,4,5 五个节点
        int[][] matrix = {
                { 0, 1, 1, 0, 0 },
                { 0, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0 }
        };
        dfs(matrix);
    }

    public static void dfs(int[][] matrix) {
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
        visited[start] = true;
        for (int i = 0; i < matrix.length; i ++) {
            if (!visited[i] && matrix[start][i] == 1) {
                helper(matrix, visited, i);
            }
        }
        System.out.println(start + 1);
    }
}
