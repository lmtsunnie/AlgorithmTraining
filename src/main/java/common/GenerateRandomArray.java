package common;

import java.util.HashSet;
import java.util.Random;

public class GenerateRandomArray {
    // 2、实现一个随机样本产生器
    public static int[] generateRandomArrayWithDuplicates(int maxSize, int maxValue) {
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

    public static int[] generateRandomArrayWithoutDuplicates(int maxSize, int maxValue) {
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();
        // 生成随机数字并存入HashSet
        // [0,maxValue)
        while (hashSet.size() < maxSize) {
            hashSet.add(random.nextInt(maxValue));
        }
        int[] array = hashSet.stream().mapToInt(Number::intValue).toArray();
        return array;
    }

    public static int[] integerArrayToIntArray(Integer[] integerArray) {
        int[] result = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            result[i] = integerArray[i];
        }
        return result;
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
}
