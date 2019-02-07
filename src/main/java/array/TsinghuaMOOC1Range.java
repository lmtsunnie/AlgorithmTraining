package array;

import java.util.Arrays;
import java.util.Scanner;

import static array.BinarySearch.binarySearchForFirstGreaterOrEqualNumIndex;
import static array.BinarySearch.binarySearchForFirstLessOrEqualNumIndex;

public class TsinghuaMOOC1Range {

/*描述
数轴上有n个点，对于任一闭区间 [a, b]，试计算落在其内的点数。

输入
第一行包括两个整数：点的总数n，查询的次数m。

第二行包含n个数，为各个点的坐标。

以下m行，各包含两个整数：查询区间的左、右边界a和b。

输出
对每次查询，输出落在闭区间[a, b]内点的个数。

样例
Input
5 2
1 3 7 9 11
4 6
7 12

Output
0
3

限制
0 ≤ n, m ≤ 5×105

对于每次查询的区间[a, b]，都有a ≤ b

各点的坐标互异

各点的坐标、查询区间的边界a、b，均为不超过10^7的非负整数

时间：2 sec

内存：256 MB*/


    public static int findLeftIndex(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            //int mid = lo + ((hi - lo) >> 1);
            // 若target <= nums[mid]，hi = mid，在[lo, mid)中找
            // 若target > nums[mid]，lo = mid + 1，在(mid, hi)中
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo; // 循环结束时，lo为>=target的最小下标，故lo-1为<target的最大下标
    } // 有多个元素命中target时，保证返回下标最小的；查找失败时返回>=target的最小下标

    public static int findRightIndex(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);

            //int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        return --lo; // 循环结束时，lo为>target的最小下标，故lo-1为<=target的最大下标
    } // 有多个元素命中target时，保证返回下标最大的；查找失败时返回<=target的最大下标


    public static int range(int[] nums, int length, int a, int b) {
        // int loRange = findLeftIndex(nums, a, 0, length);
        // int hiRange = findRightIndex(nums, b, 0, length);
        int leftIndex = binarySearchForFirstGreaterOrEqualNumIndex(nums, a);
        int rightIndex = binarySearchForFirstLessOrEqualNumIndex(nums, b);
        return rightIndex - leftIndex + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int queryTimes = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        for (int query = 1; query <= queryTimes; query ++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(range(nums, length, a, b));
        }
    }
}
