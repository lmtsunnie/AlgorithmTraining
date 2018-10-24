package sort;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            quickSort(arr);
            printArray(arr);
        }
    }

   /* public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSortPart(arr, 0, arr.length - 1);
    }

    private static void quickSortPart(int[] arr, int lo, int hi) {
        if (lo < hi) {
            // randomIndex : [l, r + 1) = l + [0, r + 1 - l)
            // 把randomIndex指向的数和最后一个数arr[hi]交换，以arr[randomIndex]为切分标准
            Swap(arr, (int) (lo + (hi - lo + 1) * Math.random()), hi);
            int[] equalRange = partition(arr, lo, hi);
            quickSortPart(arr, lo, equalRange[0] - 1);
            quickSortPart(arr, equalRange[1] + 1, hi);
        }
    }


    private static int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1, more = hi;
        int cur = lo;
        while (cur < more) {
            if (arr[cur] < arr[hi]) {
                Swap(arr, cur++, ++less);
            } else if (arr[cur] > arr[hi]) {
                Swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        Swap(arr, cur, hi);
        return new int[] {less + 1, more - 1};
    }*/
   public static void quickSort(int[] nums) {
       if (nums == null || nums.length < 2) return;
       quickSortPart(nums, 0, nums.length - 1);
   }

    public static void quickSortPart(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int[] equalRange = partition(nums, lo, hi);
        quickSortPart(nums, lo, equalRange[0] - 1);
        quickSortPart(nums, equalRange[1] + 1, hi);
    }

    public static int[] partition(int[] nums, int lo, int hi) {
        int length = hi - lo + 1;
        // 随机选取基准点和最后一个数交换
        // Math.Random() [0,1) -> (hi-lo+1) * Math.Random() [0,hi-lo+1)
        // lo + (hi-lo+1) * Math.Random() [lo, lo+hi-lo+1)=[lo, hi+1)=[lo,hi]
        swap(nums, (int) (lo + length * Math.random()), hi);
        int less = lo - 1;
        int more = hi; // more从hi开始，保护nums[hi]在大于区域中不会被换掉，最后再替换
        int cur = lo;
        while (cur < more) {
            // 小于的话，和小于边界右边的第一个数交换位置，less++
            // 小于边界右边的第一个数一定是等于区域的数，所以直接cur++
            if (nums[cur] < nums[hi]) {
                swap(nums, cur ++, ++ less);
                // 等于的话，直接cur++就可以了
            } else if (nums[cur] == nums[hi]) {
                cur ++;
                // 大于的话，和大于边界左边的第一个数交换位置，more--
                // 大于边界左边的第一个数是未知的，所以要再考察cur不能++
            } else {
                swap(nums, cur, -- more);
            }
        }
        swap(nums, more, hi);
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] nums, int lo, int hi) {
       if (lo == hi) return;
        nums[lo] = nums[lo] ^ nums[hi];
        nums[hi] = nums[lo] ^ nums[hi];
        nums[lo] = nums[lo] ^ nums[hi];
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    /*private static void Swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }*/
}