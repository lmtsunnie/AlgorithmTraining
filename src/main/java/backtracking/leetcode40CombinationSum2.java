package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.PrintDoubleArrayList.printDoubleList;

public class leetcode40CombinationSum2 {
    /*Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]*/
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0) {
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), candidates, 0, target);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> tmpList, int[] candidates, int start, int remain) {
        if (remain < 0) return;
        else if (remain == 0) {
            lists.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start; i < candidates.length; i ++) {
                if (i >= start + 1 && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                tmpList.add(candidates[i]);
                backtrack(lists, tmpList, candidates, i + 1, remain - candidates[i]);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
    /*=====================================================================================*/

    public static void main(String[] args) {
        int[] nums1 = new int[]{10,1,2,7,6,1,5};
        int target1 = 8;
        printDoubleList(combinationSum2(nums1, target1));
        System.out.println("====================");
        int[] nums2 = new int[]{2,5,2,1,2};
        int target2 = 5;
        printDoubleList(combinationSum2(nums2, target2));
    }

}
