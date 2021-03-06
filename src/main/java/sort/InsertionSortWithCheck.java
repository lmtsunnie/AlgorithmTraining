package sort;

import java.util.Arrays;
import java.util.Scanner;

import static common.GenerateRandomArray.copyArray;
import static common.PrintArray.printArray;
import static common.Swap.swap;

public class InsertionSortWithCheck {
    public static void main1(String[] args) {
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

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i ++) {
            // 待插进来的数是arr[j + 1]，若比前面的数小则和前面的数交换位置
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j --) {
                swap(arr, j, j + 1);
            }
        }
    }

    // 对数器
    // 1、实现一个绝对正确但是复杂度不好的方法b，即对数器
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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

    // 4、分别用想要测的方法a和简单的方法b对数组排序，把排序结果进行比对
    // 对比函数isEqual只有当长度一样而且每个值都对应相等时才返回true，否则返回false
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("Original array: ");
                printArray(arr3);
                System.out.println("My bubbleSort result: ");
                printArray(arr1);
                System.out.println("True result: ");
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}


