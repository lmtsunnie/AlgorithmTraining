package array;

import java.util.Arrays;

import static common.GenerateRandomArray.*;
import static common.PrintArray.printArray;

public class BinarySearch {
    /**
     * 1.1 无重复数字，二分查找出target的下标
     */
    public static int binarySearchWithoutDuplicates(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // 若target < nums[mid]，在左半段，在[lo, mid - 1]中找
            if (target < nums[mid]) {
                hi = mid - 1;
                // 若target > nums[mid]，在右半段，在[mid + 1, hi]中找
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        // 未找到
        return -1;
    }

    public static int binarySearchWithoutDuplicates2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        return helper(nums, target, 0, nums.length - 1);
    }

    public static int helper(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + ((hi - lo) >> 1);
        if (target < nums[mid]) {
            return helper(nums, target, lo, mid - 1);
        } else if (target > nums[mid]) {
            return helper(nums, target, mid + 1, hi);
        } else {
            return nums[mid];
        }
    }

    public static int binarySearchComparator(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 1.2 查找第一个大于等于某个数的下标
     * 例：int[] a = {1,2,2,2,4,8,10}，查找2，返回第一个2的下标1；
     * 查找3，返回4的下标4；查找4，返回4的下标4。如果没有大于等于target的元素，返回-1。
     */
    public static int binarySearchForFirstGreaterOrEqualNumIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // target < nums[mid]，target在左半段，
            // 如果target==nums[mid]，虽然hi = mid - 1，但是最后在左半段没有找到更小的，最后会返回mid，如{0,1,1,2,4,8,10}
            if (target <= nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        // 如果target大于数组最后一个元素，lo最后变为nums.length，即没有元素大于target，需要返回-1。
        return lo <= nums.length - 1 ? lo : -1;
    }

    /**
     * 1.3 从右边起查找第一个小于等于某个数的下标
     * 例，int[] a = {1,2,2,2,4,8,10}，查找2，返回最后一个2的下标3；查找3，返回最后一个2的下标3；
     * 查找4，返回4的下标4。如果没有<=target的元素，返回-1。
     */
    public static int binarySearchForFirstLessOrEqualNumIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // target < nums[mid]，target在左半段
            if (target < nums[mid]) {
                hi = mid - 1;
                // target > nums[mid]，target在右半段，
                // 如果target==nums[mid]，虽然lo = mid + 1，但是最后在右半段没有找到更大的，target < nums[mid]，hi会返回前一个数，如{0,1,1,2,4,8,10}
            } else {
                lo = mid + 1;
            }
        }
        // 如果target小于数组第一个元素，hi最后变为-1，即没有元素<=target，需要返回-1。
        // hi = lo - 1
        return hi >= 0 ? hi : -1;
    }

    /**
     * 【1.3的改进：1.3的下一个数就是1.4的结果】
     * 1.4 查找第一个大于某个数的下标
     * 注意：第一个小于等于某个数的下一个数就是第一个大于某个数的数
     * 例：int[] a = {1,2,2,2,4,8,10}，查找2，返回4的下标4；
     * 查找3，返回4的下标4；查找4，返回8的下标5。如果没有大于key的元素，返回-1。
     * 第一个小于等于2的数的下标是3，第一个大于2的数的下标是4
     */
    public static int binarySearchForFirstGreaterNumIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // target < nums[mid]，target在左半段，
            if (target < nums[mid]) {
                hi = mid - 1;
                // target >= nums[mid]， 第一个大于target的数在右半段
            } else {
                lo = mid + 1;
            }
        }
        // 如果target大于数组最后一个元素，lo最后变为nums.length，即没有元素大于target，需要返回-1。
        return lo <= nums.length - 1 ? lo : -1;
    }

    /**
     * 【1.2的改进：1.2的前一个数就是1.5的结果】
     * 1.5 从右边起查找第一个小于某个数的下标
     * 例，int[] a = {1,2,2,2,4,8,10}，查找2，返回1的下标0；查找3，返回最后一个2的下标3；
     * 查找4，返回最后一个2的下标3。如果没有<target的元素，返回-1。
     */
    public static int binarySearchForFirstLessNumIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // target < nums[mid]，target在左半段，
            // 如果target==nums[mid]，虽然hi = mid - 1，但是最后在左半段没有找到更小的，最后会返回mid，如{0,1,1,2,4,8,10}
            if (target <= nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        // 1.2 return lo <= nums.length - 1 ? lo : -1;
        // 如果target小于数组第一个元素，hi最后变为-1，即没有元素<=target，需要返回-1。
        // hi = lo - 1
        return hi >= 0 ? hi : -1;
    }


    /**
     * 【1.2的改进：1.2最后的返回加一个判断条件】
     * 1.5 查找第一个等于某个数的下标
     * 例：int[] a = {1,2,2,2,4,8,10}，查找2，返回第一个2的下标1；
     * 查找4，返回4的下标4。如果没有等于target的元素，返回-1。
     */
    public static int findLeftIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // target < nums[mid]，target在左半段，
            // 如果target==nums[mid]，虽然hi = mid - 1，但是最后在左半段没有找到更小的，最后会返回mid，如{0,1,1,2,4,8,10}
            if (target <= nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        // 如果target大于数组最后一个元素，lo最后变为nums.length，即没有元素大于target，需要返回-1。
        return lo <= nums.length - 1 && nums[lo] == target ? lo : -1;
    }

    public static int findLeftIndex2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            // 关注第一个=target的数，处于较为前面的位置
            // <= nums[mid]
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) { // > nums[mid]
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    /**
     * 【1.3的改进：1.3最后的返回加一个判断条件】
     * 1.6 查找最后一个等于某个数的下标，即从右边起查找第一个等于某个数的下标
     * 例，int[] a = {1,2,2,2,4,8,10}，查找2，返回最后一个2的下标3
     * 查找4，返回4的下标4。如果没有<=target的元素，返回-1。
     */
    public static int findRightIndex(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // target < nums[mid]，target在左半段
            if (target < nums[mid]) {
                hi = mid - 1;
                // target > nums[mid]，target在右半段，
                // 如果target==nums[mid]，虽然lo = mid + 1，但是最后在右半段没有找到更大的，target < nums[mid]，hi会返回前一个数，如{0,1,1,2,4,8,10}
            } else {
                lo = mid + 1;
            }
        }
        // 如果target小于数组第一个元素，hi最后变为-1，即没有元素<=target，需要返回-1。
        // hi = lo - 1
        return hi >= 0 && nums[hi] == target ? hi : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(findLeftIndex2(nums, 1));
    }

    public static int findRightIndex2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (hi - lo >= 2) {
            int mid = lo + ((hi - lo) >> 1);
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                lo = mid;
            }
        }
        if (nums[hi] == target) {
            return hi;
        } else if(nums[lo] == target) {
            return lo;
        } else {
            return -1;
        }
    }

    public static int findRightIndex3(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi - 1) {
            int mid = lo + ((hi - lo) >> 1);
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                lo = mid;
            }
        }
        if (nums[hi] == target) {
            return hi;
        } else if(nums[lo] == target) {
            return lo;
        } else {
            return -1;
        }
    }

    /**
     * 【1.5和1.6的改进】
     * 1.7 查找一个数出现的次数
     */
    public static int getCount(int[] nums, int target) {
        int leftIndex = findLeftIndex2(nums, target);
        int rightIndex = findRightIndex2(nums, target);
        return rightIndex - leftIndex + 1;
    }

    public static int getCountComparator(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 【1.1的改进】
     * 1.8 把排序好的数组分成两部分，两部分互换顺序
     * 在有序数组断节后找到min数的index
     */
    public static int findMinIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // mid < hi：最小值在左半部分,也可能是自己
            if (nums[mid] < nums[hi]) {
                hi = mid;
                // mid > hi：最小值在右半部分，不可能是自己了
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static int findMinIndexComparator(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            minIndex = nums[i] < nums[minIndex] ? i : minIndex;
        }
        return minIndex;
    }

    public static int[] moveArray(int[] nums) {
        // [0, nums.length)
        int moveNum = (int) ((nums.length) * Math.random());
        int left = nums.length - moveNum;
        int[] res = new int[nums.length];
        // 把后面的搬到前面来
        for (int i = 0; i < left; i++) {
            res[i] = nums[i + moveNum];
        }
        for (int i = left; i < nums.length; i++) {
            res[i] = nums[i - left];
        }
        return res;
    }


    public static void main4(String[] args) {
        int testTime = 50;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArrayWithoutDuplicates(maxSize, maxValue);
            Arrays.sort(arr1);
            arr1 = moveArray(arr1);
            int[] arr2 = copyArray(arr1);
            // random [0,1)
            // random * length [0,length)
            if (arr1.length <= 0) {
                continue;
            }
            // Collections.singletonList(arr1).forEach(x -> System.out.println(Arrays.toString(x) + " "));
            // printArray(arr1);
            if (findMinIndex(arr1) != findMinIndexComparator(arr2)) {
                succeed = false;
                System.out.print("nums[]: ");
                printArray(arr2);
                System.out.println("find:" + findMinIndex(arr1));
                System.out.println("true:" + findMinIndexComparator(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void main5(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArrayWithDuplicates(maxSize, maxValue);
            Arrays.sort(arr1);
            int[] arr2 = copyArray(arr1);
            int target = 0;
            // random [0,1)
            // random * length [0,length)
            if (arr1.length <= 0) {
                continue;
            }
            target = arr1[(int) (Math.random() * arr1.length)];
            printArray(arr2);
            // Collections.singletonList(arr1).forEach(x -> System.out.println(Arrays.toString(x) + " "));
            if (getCount(arr1, target) != getCountComparator(arr2, target)) {
                succeed = false;
                System.out.print("nums[]: ");
                printArray(arr2);
                System.out.println("target: " + target);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void main3(String[] args) {
        int[] num = {0, 1, 1, 2, 4, 8, 10};
        System.out.println(binarySearchForFirstGreaterOrEqualNumIndex(num, 2));
        System.out.println(binarySearchForFirstLessOrEqualNumIndex(num, -1));
        System.out.println(binarySearchForFirstLessOrEqualNumIndex(num, 2));
        System.out.println(binarySearchForFirstGreaterNumIndex(num, 2));
        System.out.println(binarySearchForFirstGreaterNumIndex(num, 11));
    }

    public static void main2(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 9, 10};
        System.out.println(binarySearchWithoutDuplicates(nums, 1));
        System.out.println(binarySearchWithoutDuplicates(nums, 10));
        System.out.println(binarySearchWithoutDuplicates(nums, 7));
        System.out.println(binarySearchWithoutDuplicates(nums, 8));
    }

    public static void main1(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArrayWithoutDuplicates(maxSize, maxValue);
            Arrays.sort(arr1);
            int[] arr2 = copyArray(arr1);
            // random [0,1)
            // random * length [0,length)
            int target = arr1[(int) (Math.random() * arr1.length)];
            if (binarySearchWithoutDuplicates2(arr1, target) != binarySearchComparator(arr2, target)) {
                succeed = false;
                System.out.print("nums[]: ");
                printArray(arr2);
                System.out.println("target: " + target);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
