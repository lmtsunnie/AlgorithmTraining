package sword_to_offer_sort;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
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

    private static void mergeSort(int[] arr) {
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
        int[] helper = new int[r - l + 1];
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            helper[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helper[i++] = arr[p2++];
        }
        for (i = 0; i < helper.length; i ++) {
            arr[l + i] = helper[i];
        }
    }
}
