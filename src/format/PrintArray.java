package format;

public class PrintArray {
    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[nums.length - 1]);
    }
}
