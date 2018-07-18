package sword_to_offer_sort;

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

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 建堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int maxIndex = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            maxIndex = arr[maxIndex] > arr[index] ? maxIndex : index;
            if (maxIndex == index) break;
            swap(arr, index, maxIndex);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length < 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1]);
    }
}

