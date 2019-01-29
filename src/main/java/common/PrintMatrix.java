package common;

public class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        for (int[] nums : matrix) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
    }
}
