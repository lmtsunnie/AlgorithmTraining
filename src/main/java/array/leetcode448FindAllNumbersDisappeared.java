package array;

import java.util.ArrayList;

import static common.PrintArray.printArray;

public class leetcode448FindAllNumbersDisappeared {
    /*448. find All Numbers Disappeared in an Array
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
some elements appear twice and others appear once.

find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/
    /*=====================================================================================*/
    public static ArrayList<Integer> findNumbersNotAppear(int[] nums) {
     /*自己没想到，看的讨论区的：
     时间复杂度O(n)，空间复杂度O(1)
     因为 1 <= 值 <= n， 0 <= 索引 <= n - 1
     * 第一遍遍历数组，n出现了就把第n位上的数取负号作为标记，再遍历一遍数组，正数所在的为第几位几就是没出现过的数
     * 自己觉得污染了原始数据，最好再把数组复原成原始数组*/
     if (nums == null || nums.length == 0) return null;
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }
        /*迭代器只是取数，不能赋值
        for (int num : nums) {
            if (num < 0) {
                num = -num;
            }
        }*/
        return res;
    }
    /*=====================================================================================*/
    // 打印函数：
    public static void printArrayList(ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*=====================================================================================*/
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        printArray(nums);
        printArrayList(findNumbersNotAppear(nums));
        printArray(nums);
    }
}
