package common;

import static common.PrintArray.printArray;

public class Swap {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3};
        printArray(nums);
        swap(nums, 1, 2);
        printArray(nums);
    }
}
