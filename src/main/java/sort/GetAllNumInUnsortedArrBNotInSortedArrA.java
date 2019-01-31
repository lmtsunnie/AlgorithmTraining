package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static common.GenerateRandomArray.copyArray;

public class GetAllNumInUnsortedArrBNotInSortedArrA {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int lenA = scanner.nextInt();
            int lenB = scanner.nextInt();
            int[] arrA = new int[lenA];
            int[] arrB = new int[lenB];
            for (int i = 0; i < lenA; i++) {
                arrA[i] = scanner.nextInt();
            }
            for (int i = 0; i < lenB; i++) {
                arrB[i] = scanner.nextInt();
            }
            Arrays.sort(arrB);
            ArrayList<Integer> res = getAllNumInUnsortedArrBNotInSortedArrA(arrA, arrB);
            printArrayList(res);
        }
        scanner.close();
    }

    public static ArrayList<Integer> getAllNumInUnsortedArrBNotInSortedArrA(int[] arrA, int[] arrB) {
        int pA = 0, pB = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (pA <= arrA.length - 1 && pB <= arrB.length - 1) {
            if (arrA[pA] > arrB[pB]) {
                res.add(arrB[pB++]);
            } else if (arrA[pA] < arrB[pB]) {
                pA++;
            } else {
                pB++;
            }
        }
        /*
        // B越界，B数组用完了
        while (pA <= arrA.length - 1) {
            return res;
        }*/
        // A越界，A数组用完了
        while (pB <= arrB.length - 1) {
            res.add(arrB[pB++]);
        }
        return res;
    }

    private static void printArrayList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(arr.get(arr.size() - 1));
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    // 对数器
    // 1、实现一个绝对正确但是复杂度不好的方法b，即对数器
    // 对B数组中的每一个数都搜一下在A中有没有
    public static ArrayList<Integer> comparator(int[] arrA, int[] arrB) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arrB.length; i++) {
            int flag = 0;
            for (int j = 0; j < arrA.length && flag == 0; j++) {
                if (arrB[i] == arrA[j]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                res.add(arrB[i]);
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
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // 3、将产生的随机数组拷贝成两份


    // 4、分别用想要测的方法a和简单的方法b对数组排序，把排序结果进行比对
    // 对比函数isEqual只有当长度一样而且每个值都对应相等时才返回true，否则返回false
    public static boolean isEqual(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.size() != arr2.size())
            return false;
        for (int i = 0; i < arr1.size() - 1; i++) {
            if (arr1.get(i) != arr2.get(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 4;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arrA1 = generateRandomArray(maxSize, maxValue);
            int[] arrB1 = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arrA1);
            Arrays.sort(arrB1);
            int[] arrA2 = copyArray(arrA1);
            int[] arrA3 = copyArray(arrA1);
            int[] arrB2 = copyArray(arrB1);
            int[] arrB3 = copyArray(arrB1);
            ArrayList<Integer> res = getAllNumInUnsortedArrBNotInSortedArrA(arrA1, arrB1);
            ArrayList<Integer> compRes = comparator(arrA2, arrB2);
            if (!isEqual(res, compRes)) {
                succeed = false;
                System.out.println("arrA is: ");
                printArray(arrA3);
                System.out.println("arrB is: ");
                printArray(arrB3);
                System.out.println("My result: ");
                printArrayList(res);
                System.out.println("True result: ");
                printArrayList(compRes);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
