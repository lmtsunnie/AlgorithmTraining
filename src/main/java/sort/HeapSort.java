package sort;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            heapSort(arr);
            printArray(arr);
        }
        scanner.close();
    }

    /*public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 建堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        Swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            Swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int maxIndex = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            maxIndex = arr[maxIndex] > arr[index] ? maxIndex : index;
            if (maxIndex == index) break;
            Swap(arr, index, maxIndex);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }*/
    public static void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] nums, int i, int heapSize) {
        int leftIndex = 2 * i + 1;
        while (leftIndex <= heapSize - 1) {
            int maxIndex = leftIndex + 1 <= heapSize - 1 && nums[leftIndex + 1] > nums[leftIndex] ? leftIndex + 1 : leftIndex;
            maxIndex = nums[maxIndex] > nums[i] ? maxIndex : i;
            if (maxIndex == i) return;
            swap(nums, maxIndex, i);
            i = maxIndex;
            leftIndex = 2 * i + 1;
        }
    }

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i ++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        while (heapSize >= 2) {
            swap(nums, 0, -- heapSize);
            heapify(nums, 0, heapSize);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void printArray(int[] arr) {
        if (arr == null || arr.length < 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}

