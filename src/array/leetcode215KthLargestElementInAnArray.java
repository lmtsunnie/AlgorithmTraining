package array;

import java.util.Arrays;

public class leetcode215KthLargestElementInAnArray {
    /*Find the kth largest element in an unsorted array.
    Note that it is the kth largest element in the sorted order,
    not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

/*=====================================================================================*/
    /*
    * 自想1：
    * 先排序再直接返回nums[n - k]
    * 时间复杂度O(nlogn)，空间复杂度O(1)
    * */
    public static int kthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
 /*=====================================================================================*/
    /*
    * 自想2：
    * 先找第1大的数，用max变量记录
    * 再跳过第1大的数找第2大的数，更新max为第2大的数，
    * ...跳过前i-1大的i-1个数找第i大的数，更新max为第i大的数
    * ...跳过前k-1大的k-1个数找第k大的数，更新max为第k大的数并返回
    * 时间复杂度O(n*k)，空间复杂度O(1)
    * */
    public static int kthLargest2(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int count; // 算第i大的数一共有几个
        for (int i = 1; i <= k; i += count) {
            int tmpMax = Integer.MIN_VALUE;
            for (int num : nums) {
                if (i > 1 && num >= max) continue; // 跳过已经找过的前i-1大的i-1个数
                tmpMax = num > tmpMax ? num : tmpMax;
            }
            count = 0;
            max = tmpMax;
            for (int num : nums) {
                if (num == max) {
                    count ++;
                }
            }
        }
        return max;
    }
    /*=====================================================================================*/
    

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,1,5,6,4};
        System.out.println(kthLargest1(nums1, 2));
        System.out.println(kthLargest2(nums1, 2));
        System.out.println("================");
        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargest1(nums2,4));
        System.out.println(kthLargest2(nums2,4));
    }
}
