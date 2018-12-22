package format;

public class PrintDoubleArray {
    public static void printDoubleArray(int[][] nums) {
        for (int i = 0; i < nums.length; i ++) {
            if (i != 0) {
                System.out.println();
            }
            for (int j = 0; j < nums[i].length; j ++) {
                System.out.print(nums[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{2,3,4},{3,4,5}};
        printDoubleArray(nums);
    }
}
