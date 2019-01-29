package sort;

import java.util.Scanner;

import static common.PrintArray.printArray;
import static common.Swap.swap;

public class BubbleSort {
    /*实现一个冒泡排序，然后输入数字“100 80 50 70 85 34 60”，看排序结果。*/
    // 第一行输入待排序数组的个数，在这里输入7
    // 第二行输入待排序数组，这里输入7个数字100 80 50 70 85 34 60
    // 回车输出结果
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            bubbleSort(arr);
            printArray(arr);
        }
        sc.close();
    }

    private static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 两两比较，大的沉底。i是轮数，在进行第i轮的时候确定了最大的i个值；如果一轮下来都没有交换证明已经有序
        // 时间复杂度O(n²)，空间复杂度O(1)
        boolean sorted = true;
        for (int i = 0; i <= nums.length - 1; i ++) {
            for (int j = 0; j <= nums.length - 2 - i; j ++) {
                if (nums[j] > nums[j + 1]) {
                    sorted = false;
                    swap(nums, j, j + 1);
                }
            }
            if (sorted) {
                return;
            }
        }
    }
}
