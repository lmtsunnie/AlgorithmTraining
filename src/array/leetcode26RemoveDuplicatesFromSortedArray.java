package array;

public class leetcode26RemoveDuplicatesFromSortedArray {
    /*
    Given a sorted array nums, remove the duplicates in-place
    such that each element appear only once and return the new length.

    Do not allocate extra space for another array,
    you must do this by modifying the Input array in-place with O(1) extra memory.

    Example 1:
    Given nums = [1,1,2],
    Your function should return length = 2,
    with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.

    Example 2:
    Given nums = [0,0,1,1,1,2,2,3,3,4],
    Your function should return length = 5,
    with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
    It doesn't matter what values are set beyond the returned length.
    */

    /*=====================================================================================*/
    /*
    * 自想1：
    * 由于数组是已经排好序的，用j遍历数组，用i存储不重复的元素。j从1开始，i从0开始。
    * 如果nums[j] != nums[i]那么把j位置的数赋值给++i位置的数（++i位置是重复的位置，覆盖也没关系）
    * j遍历完，由于题目说了后面的数不用管，函数直接返回i的大小
    * */
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        int i = 0, j = 1;
        for (; j < nums.length; j ++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int n = removeDuplicatesFromSortedArray(nums);
        System.out.println(n);
        for (int i = 0; i < n; i ++) {
            System.out.print(nums[i] + " ");
        }
    }

}