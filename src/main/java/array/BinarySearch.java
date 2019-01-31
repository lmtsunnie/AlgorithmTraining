package array;

import java.util.Arrays;

import static common.GenerateRandomArray.*;
import static common.PrintArray.printArray;

public class BinarySearch {
    /**
     * 无重复数字，二分查找出target的下标
     */
    public static int binarySearchWithoutDuplicates(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("input is invalid!");
        }
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            // 若target <= nums[mid]，在左半段，hi = mid，在[lo, mid)中找
            // 若target > nums[mid]，在右半段，lo = mid + 1，在[mid + 1, hi)中
            if (target <= nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == nums.length || target != nums[lo]) {
            return -1;
        }
        return lo;
    }

    public static int binarySearchComparator(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("input is invalid!");
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 9, 10};
        System.out.println(binarySearchWithoutDuplicates(nums, 1));
        System.out.println(binarySearchWithoutDuplicates(nums, 10));
        System.out.println(binarySearchWithoutDuplicates(nums,7));
        System.out.println(binarySearchWithoutDuplicates(nums,8));
    }

    public static void main1(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArrayWithoutDuplicates(maxSize, maxValue);
            Arrays.sort(arr1);
            int[] arr2 = copyArray(arr1);
            // random [0,1)
            // random * length [0,length)
            int target = arr1[(int) (Math.random() * arr1.length)];
            if (binarySearchWithoutDuplicates(arr1, target) != binarySearchComparator(arr2, target)) {
                succeed = false;
                System.out.print("nums[]: ");
                printArray(arr2);
                System.out.println("target: " + target);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
}
