package sword_to_offer_sort;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = scanner.nextInt();
            }
            insertionSort(arr);
            printArray(arr);
        }
        scanner.close();
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1]);
    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i ++) {
            // 待插进来的数是arr[j + 1]，若比前面的数小则和前面的数交换位置
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j --) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
