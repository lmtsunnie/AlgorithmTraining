package basic_course_sort;

import java.util.Arrays;
import static common.GenerateRandomArray.copyArray;

public class Code_11_MaxGap_sunnie {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 找到n个数中的最大值和最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // 所有数都相同
        if (min == max) return 0;
        // 每个桶的三个参数：hasNum记录是否有数进入，maxs，mins记录每个桶中的最大值和最小值组成的序列
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        // bid为进几号桶
        for (int i = 0; i < len; i++) {
            int bid = bucket(nums[i], len, min, max);
            // 记录该桶中的最大值和最小值
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        // lastMax记录上一个桶中的最大值，mins[i]为当前桶的最小值
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) (len * (num - min) / (max - min) );
    }

    // 对数器
    // 1、实现一个绝对正确但是复杂度不好的方法b，即对数器
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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


    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 3;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                System.out.println("Original array: ");
                printArray(arr3);
                System.out.println("Sorted array：");
                Arrays.sort(arr3);
                printArray(arr3);
                System.out.println("My MaxGap result: ");
                System.out.println(maxGap(arr1));
                System.out.println("True result: ");
                System.out.println(comparator(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}