package array;

public class leetcode33SearchInRotatedSortedArray {
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

    /**
     * 讨论区：分成3种情况查找，主要是找到minIndex
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int smallNumIndex = findMinIndex(nums);
        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            return binarySearch(nums, 0, smallNumIndex - 1 >= 0 ? smallNumIndex - 1 : nums.length - 1, target);
        } else {
            return binarySearch(nums, smallNumIndex, nums.length - 1, target);
        }
    }

    public static int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findMinIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // mid < hi：最小值在左半部分也可能是自己
            if (nums[mid] < nums[hi]) {
                hi = mid;
                // mid > hi：最小值在右半部分，不可能是自己了
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(findMinIndex(nums));
        System.out.println(search(nums, 8));
    }
}
