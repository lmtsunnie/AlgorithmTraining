package sort;

import java.util.Arrays;
import java.util.Scanner;
import static common.GenerateRandomArray.copyArray;


public class MergeSortWithCheck {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = scanner.nextInt();
            }
            mergeSort(arr);
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length < 1) return;
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    /*private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int p1 = l, p2 = mid + 1;
        int[] dfs = new int[r - l + 1];
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            dfs[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            dfs[i++] = arr[p1++];
        }
        while (p2 <= r) {
            dfs[i++] = arr[p2++];
        }
        for (i = 0; i < dfs.length; i ++) {
            arr[l + i] = dfs[i];
        }
    }*/

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        mergeSortPart(nums, 0, nums.length - 1);
    }

    public static void mergeSortPart(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        mergeSortPart(nums, lo, mid);
        mergeSortPart(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {
        int length = hi - lo + 1;
        int[] helper = new int[length];
        // !!!error: p2 = mid + 1;
        int p1 = lo, p2 = mid + 1;
        int i = 0;
        /*while(p1 <= mid && p2 <= hi) {
            if (nums[p1] <= nums[p2]) {
                dfs[i++] = nums[p1++];
            } else if (nums[p2] < nums[p1]) {
                dfs[i++] = nums[p2++];
            }
        }
        // p1走完
        if (p1 > mid) {
            while (i < length) {
                dfs[i++] = nums[p2++];
            }
        } else { // p2走完
            while (i < length) {
                dfs[i++] = nums[p1++];
            }
        }*/
        while (p1 <= mid && p2 <= hi) {
            helper[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            helper[i++] = nums[p1++];
        }
        while (p2 <= hi) {
            helper[i++] = nums[p2++];
        }


        // !!!error: 手残多写了一个int，i已经被定义了
        for (i = 0; i < length; i ++) {
            nums[lo + i] = helper[i];
        }
    }

    // 对数器
    // 1、实现一个绝对正确但是复杂度不好的方法b，即对数器
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    // 2、实现一个随机样本产生器
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 生成一个数组长度为[0, maxSize]的数组
        // Math.random()得到[0,1)
        // Math.random() * (maxSize + 1)得到[0, maxSize + 1)
        // (int) (M(maxSize + 1) * Math.random())得到[0, maxSize]中的随机整数
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // (int) ((maxValue + 1) * Math.random())得到[0, maxValue]中的随机整数
            //  - (int) ((maxValue + 1） * Math.random())得到[ - maxValue, 0]中的随机整数
            // (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1)* Math.random())得到[-maxValue, maxValue]中的随机整数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1)* Math.random());
        }
        return arr;
    }
    // 3、将产生的随机数组拷贝成两份

    // 4、分别用想要测的方法a和简单的方法b对数组排序，把排序结果进行比对
    // 对比函数isEqual只有当长度一样而且每个值都对应相等时才返回true，否则返回false
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 4;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            mergeSort(arr1);
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
