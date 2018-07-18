package sword_to_offer_sort;

import java.util.Scanner;

public class BubbleSort {
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

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1]);
    }


    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int end = arr.length - 1; end >= 1; end --) {
            for (int i = 0; i <= end - 1; i ++) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
