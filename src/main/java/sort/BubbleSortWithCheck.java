package sort;

import java.util.Arrays;
import java.util.Scanner;

import static common.GenerateRandomArray.*;
import static common.PrintArray.printArray;

public class BubbleSortWithCheck {
    public static void main1(String[] args) {
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
    }


  /*  private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int end = arr.length - 1; end >= 1; end --) {
            for (int i = 0; i <= end - 1; i ++) {
                if (arr[i] > arr[i + 1])
                    Swap(arr, i, i + 1);
            }
        }
    }*/
  public static void bubbleSort(int[] nums) {
      // 两两比较，大的沉底。i是轮数，在进行第i轮的时候确定了最大的i个值；如果一轮下来都没有交换证明已经有序
      // 时间复杂度O(n²)，空间复杂度O(1)
      boolean sorted = true;
      for (int i = 0; i <= nums.length - 1; i ++) {
          for (int j = 0; j <= nums.length - 2 - i; j ++) {
              if (nums[j] > nums[j + 1]) {
                  sorted = false;
                  int tmp = nums[j];
                  nums[j] = nums[j + 1];
                  nums[j + 1] = tmp;
              }
          }
          if (sorted) {
              return;
          }
      }
  }

    // 对数器
    // 1、实现一个绝对正确但是复杂度不好的方法b，即对数器
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArrayWithDuplicates(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("Original array: ");
                printArray(arr3);
                System.out.println("My bubbleSort result: ");
                printArray(arr1);
                System.out.println("True result: ");
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

