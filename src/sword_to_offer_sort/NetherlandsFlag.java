package sword_to_offer_sort;

import java.util.Scanner;

public class NetherlandsFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = scanner.nextInt();
            }
            int num = scanner.nextInt();
            partition(arr, num);
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void partition(int[] arr, int num) {
        if (arr == null || arr.length < 2) return;
        int less = -1, more = arr.length;
        int cur = 0;
        while (cur != more) {
            if (arr[cur] < num) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > num) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
    }
}
