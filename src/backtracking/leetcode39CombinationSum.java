package backtracking;

import java.util.ArrayList;
import java.util.List;

import static format.PrintDoubleArrayList.printDoubleList;

public class leetcode39CombinationSum {
    /*Given a set of candidate numbers (candidates)
    (without duplicates) and a target number (target),
    find all unique combinations in candidates
    where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/

    /*=====================================================================================*/
    /*讨论区：
    自己没有考虑到remain<0的情况和else的使用
    经典回溯问题：
    Pick a starting point.
    while(Problem is not solved)
        For each path from the starting point.
            check if selected path is safe, if yes select it
            and make recursive call to rest of the problem
            before which undo the current move.
        End For
    If none of the move works out, return false, NO SOLUTON.
     时间复杂度O(n²)，空间复杂度O(n)
    * */
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); 不sort也可以，没说tmpList中的数要按大小顺序排列
        backtrack(list, new ArrayList<>(), nums, 0, target);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums, int start, int remain) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tmpList));
        } else { // 找到了一个符合要求的tmpList之后不会再在tmpList上添加
            for (int i = start; i < nums.length; i++) {
                tmpList.add(nums[i]);
                backtrack(list, tmpList, nums, i, remain - nums[i]);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    /*=====================================================================================*/

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 5};
        int target1 = 8;
        printDoubleList(combinationSum(nums1, target1));
        System.out.println("====================");
        int[] nums2 = new int[]{2, 3, 6, 7};
        int target2 = 7;
        printDoubleList(combinationSum(nums2, target2));
    }
}
