package backtracking;

import java.util.ArrayList;
import java.util.List;

import static format.PrintDoubleArrayList.printDoubleList;

public class leetcode46Permutation {
    /*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums);
        return lists;
    }
    public static void backtrack(List<List<Integer>> lists, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            lists.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i ++) {
                if (tmpList.contains(nums[i])) {
                    continue;
                }
                tmpList.add(nums[i]);
                backtrack(lists, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        printDoubleList(permute(nums));

    }
}
