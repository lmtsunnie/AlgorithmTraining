package sort;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = scanner.nextInt();
            }
            selectionSort(arr);
            printArray(arr);
        }
        scanner.close();
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int start = 0; start < arr.length - 1; start ++) {
            int minIndex = start;
            for (int i = start; i < arr.length; i ++) {
                minIndex = arr[i] < arr[minIndex] ? i : minIndex;
            }
            swap(arr, start, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
