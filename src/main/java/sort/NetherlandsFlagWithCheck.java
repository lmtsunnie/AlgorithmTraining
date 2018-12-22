package sort;

import java.util.Scanner;

public class NetherlandsFlagWithCheck {
    public static void main1(String[] args) {
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
    public static void main(String[] args) {
        int testTime = 3;
        int maxSize = 10;
        int maxValue = 3;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            // Math.random()得到[0,1)
            // Math.random() * (maxValue + 1)得到[0, maxValue + 1)
            // (int) ((maxValue + 1) * Math.random())得到[0, maxValue]中的随机整数
            int randomNum = (int) ((maxValue + 1) * Math.random());
            System.out.println("randomNum is " + randomNum);
            partition(arr1, randomNum);
            System.out.println("Original array: ");
            printArray(arr2);
            System.out.println("My partition result: ");
            printArray(arr1);
            System.out.println("==========================================");
        }
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
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

    // 2、实现一个随机样本产生器
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 生成一个数组长度为[0, maxSize]的数组
        // Math.random()得到[0,1)
        // Math.random() * (maxSize + 1)得到[0, maxSize + 1)
        // (int) ((maxSize + 1) * Math.random())得到[0, maxSize]中的随机整数
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // (int) ((maxValue + 1) * Math.random())得到[0, maxValue]中的随机整数
            arr[i] = (int) ((maxValue + 1) * Math.random());
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

}
