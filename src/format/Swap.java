package format;

public class Swap {
    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3};
        printArray(nums);
        swap(nums, 1, 2);
        printArray(nums);
    }
}
