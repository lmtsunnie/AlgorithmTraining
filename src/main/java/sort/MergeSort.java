package sort;

import java.util.Scanner;

import static common.PrintArray.printArray;

public class MergeSort {
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSortPart(arr, 0, arr.length - 1);
    }

    private static void mergeSortPart(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortPart(arr, lo, mid);
        mergeSortPart(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int p1 = lo, p2 = mid + 1;
        int[] helper = new int[hi - lo + 1];
        int i = 0;
        while (p1 <= mid && p2 <= hi) {
            helper[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= hi) {
            helper[i++] = arr[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            arr[lo + i] = helper[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            mergeSort(arr);
            printArray(arr);
        }
    }
}
