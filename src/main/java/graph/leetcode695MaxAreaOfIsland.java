package graph;

public class leetcode695MaxAreaOfIsland {
    /*
    Given a non-empty 2D array grid of 0's and 1's,
    an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
    You may assume all four edges of the grid are surrounded by water.

    find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

    Example 1:
           [[0,0,1,0,0,0,0,1,0,0,0,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,1,1,0,1,0,0,0,0,0,0,0,0],
            [0,1,0,0,1,1,0,0,1,0,1,0,0],
            [0,1,0,0,1,1,0,0,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0,0,1,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
            Example 2:
            [[0,0,0,0,0,0,0,0]]
    Given the above grid, return 0.
    Note: The length of each dimension in the given grid does not exceed 50.
    */

    /* 自想1：从左到右从上到下遍历，如果自己是1再查看左边nums[i][j-1]和上面nums[i-1][j]是不是1，
       由于nums[i-1][j]可能被累加到nums[i-1][j+1]上了，所以上面的数要取max{nums[i-1][j], nums[i-1][j+1]}
       取总和放在自己的位置上， 相加了的左边的和上面的数都清零，
       遍历过程中如果值大于max则更新max值，遍历完成后的max就是max island的大小
       没过！！！bug一堆！！！
       */
    public static int maxAreaOfIsland(int[][] nums) {
        int max = nums[0][0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                // 第一行的数除了nums[0][0]
                if (i == 0 && j > 0) {
                    if (nums[i][j] != 0) {
                        nums[i][j] += nums[i][j - 1];
                    }
                    max = nums[i][j] > max ? nums[i][j] : max;
                }
                // 第一列的数
                else if (i > 0 && j == 0) {
                    if (nums[i][j] != 0) {
                        if (nums[i - 1][j] != 0) {
                            if (j + 1 < nums[0].length) {
                                int k = 0;
                                for (; j + k < nums[0].length && nums[i - 1][j + k] > 0; k++) {
                                }
                                nums[i][j] += j + k == nums.length - 1 ? nums[i - 1][j + k] : nums[i - 1][j + k - 1];
                            } else {
                                nums[i][j] += nums[i - 1][j];
                            }
                        }
                    }
                    max = nums[i][j] > max ? nums[i][j] : max;
                }
                // 最后一列的数
                else if (i > 0 && j == nums[0].length - 1) {
                    if (nums[i][j] != 0) {
                        // 上面左边左上方都有值
                        if (nums[i - 1][j - 1] != 0 && nums[i][j - 1] != 0 && nums[i - 1][j] != 0) {
                            nums[i][j] += Math.max(nums[i][j - 1], nums[i - 1][j]);
                        } else {
                            // 左边的数只算了左边和上面，现在算右边
                            if (nums[i][j - 1] != 0) {
                                nums[i][j] += nums[i][j - 1];
                            }
                            // 上面那个数四面都算过了
                            if (nums[i - 1][j] != 0) {
                                nums[i][j] += nums[i - 1][j];
                            }
                        }
                    }
                    max = nums[i][j] > max ? nums[i][j] : max;
                }
                // 中间的数
                else if (i > 0 && j > 0) {
                    if (nums[i][j] != 0) {
                        // 上面左边左上方都有值
                        if (nums[i - 1][j - 1] != 0 && nums[i][j - 1] != 0 && nums[i - 1][j] != 0) {
                            nums[i][j] += Math.max(nums[i][j - 1], nums[i - 1][j]);
                        } else {
                            // 左边的数只算了左边和上面，现在算右边
                            if (nums[i][j - 1] != 0) {
                                nums[i][j] += nums[i][j - 1];
                            }
                            // 上面那个数四面都算过了
                            if (nums[i - 1][j] != 0) {
                                if (j + 1 < nums[0].length) {
                                    int k = 0;
                                    for (; j + k < nums[0].length && nums[i - 1][j + k] > 0; k++) {
                                    }
                                    nums[i][j] += j + k == nums.length - 1 ? nums[i - 1][j + k] : nums[i - 1][j + k - 1];
                                } else {
                                    nums[i][j] += nums[i - 1][j];
                                }
                            }
                        }
                    }
                    max = nums[i][j] > max ? nums[i][j] : max;
                }
            }
        }
        return max;
    }
}
