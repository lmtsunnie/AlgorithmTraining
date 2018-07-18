package sword_to_offer_sort;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            quickSort(arr);
            printArray(arr);
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // randomIndex : [l, r + 1) = l + [0, r + 1 - l)
            // 把randomIndex指向的数和最后一个数arr[r]交换，以arr[randomIndex]为切分标准
            swap(arr, (int) (l + (r - l + 1) * Math.random()), r);
            int[] equalRange = partition(arr, l, r);
            quickSort(arr, l, equalRange[0] - 1);
            quickSort(arr, equalRange[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1, more = r;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > arr[r]) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        swap(arr, cur, r);
        return new int[] {less + 1, more - 1};
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}