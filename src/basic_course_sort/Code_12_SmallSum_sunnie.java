package basic_course_sort;

import java.util.Arrays;

public class Code_12_SmallSum_sunnie {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
}

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) // 左侧过程中排的过程中产生的小和
               + mergeSort(arr, mid + 1, r) // 右侧过程中排的过程中产生的小和
               + merge(arr, l, mid, r); // merge过程中产生的小和
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // p1未越界意味着p2越界，把p1剩下的填进help数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // p2未越界意味着p1越界，把p2剩下的填进help数组
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // help.length != arr.length, arr是整个数组，help对应arr[L] ~ arr[R]的部分，长度为R - L + 1
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
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
    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
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

    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 4;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            smallSum(arr1);
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

