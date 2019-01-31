package array;

import static common.PrintArray.printArray;
import static common.GenerateRandomArray.copyArray;

public class cskaoyanP18T10 {
    public static void moveLeftN(int[] nums, int p) {
        /* 错误：如果nums.length是奇数可以实现，偶数就不行，
        因为终止条件设置的是回到起始的位置，偶数的时候回到起始位置只交换了一半数据

         0,1,2,3,4
         3,4,0,1,2
         左移p个位置相当于右移n-p个位置，和p=1的情况类比，从后开始移动
         时间复杂度O(n)，空间复杂度O(1)
        */
        int n = nums.length;
        // n-1即将覆盖掉的位置是(n-1+n-p)%n=(2n-1-p)%n
        int tmp = nums[(2 * n - 1 - p) % n];
        int end = 0;
        int start = n - 1;
        while (true) {
            end = (start + n - p) % n;
            nums[end] = nums[start];
            start = (start - (n - p)) >= 0 ? (start - (n - p)) : (start - (n - p) + n);
            if (start == n - 1) {
                break;
            }
        }
        // 把第一个被覆盖的位置还原，当start=(2n-1-p)%n时，end=(2n-1-p+n-p)%n=(3n-1-2p)%n
        nums[(3 * n - 1 - 2 * p) % n] = tmp;
    }

    /*1、绝对正确的对数器，用来判定目标函数是否正确
     * 时间复杂度O(n)，空间复杂度O(n)
     * */
    public static int[] comparator(int[] nums, int p) {
        int n = nums.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            int end = i - p >= 0 ? i - p : i - p + n;
            copy[end] = nums[i];
        }
        return copy;
    }

    // 2、实现一个随机样本产生器
    public static int[] generateRandomArray(int size, int maxValue) {
        // 生成一个数组长度为size的数组
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            // (int) ((maxValue + 1) * Math.random())得到[0, maxValue]中的随机整数
            //  - (int) ((maxValue + 1） * Math.random())得到[ - maxValue, 0]中的随机整数
            // (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1)* Math.random())得到[-maxValue, maxValue]中的随机整数
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
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
        int size = 4;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int p = (int) (size * Math.random()); // 得到[0, size)中的随机整数
            moveLeftN(arr1, p);
            int[] trueRes = comparator(arr2, p);
            if (!isEqual(arr1, trueRes)) {
                succeed = false;
                System.out.println("Original array: ");
                printArray(arr3);
                System.out.println("My result: ");
                printArray(arr1);
                System.out.println("True result: ");
                printArray(trueRes);
                System.out.println("p = " + p);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck U Baby!");
    }
}

