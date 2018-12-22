package sort;

import java.util.Scanner;

public class SmallSum {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(smallSum(arr));
        }
        scanner.close();
    }

    private static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            res = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
        }
        return res;
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int res = 0;
        int i = 0;
        int[] helper = new int[r - l + 1];
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            // p1指的数小才有小和
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p2越界
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        //p1越界
        while (p2 <= r) {
            helper[i++] = arr[p2++];
        }

        for (i = 0; i < helper.length; i ++) {
            arr[l + i] = helper[i];
        }
        return res;
    }

    // 对数器
    // 1、实现一个绝对正确但是复杂度不好的方法b，即对数器
    public static int comparator(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] < arr[i])
                    res += arr[j];
            }
        }
        return res;
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
    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 50;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                System.out.println("Input array: ");
                printArray(arr3);
                System.out.println("My result: " + smallSum(arr1));
                System.out.println("True result: " + comparator(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
