package basic_course_sort;

public class Code_08_NetherlandsFlag_sunnie {
    // 返回等于区域的下标范围
    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur); // 大于时换过来的cur还要考察，cur不变
            } else {
                cur++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
            partition(arr1, 0, arr1.length - 1, randomNum);
            System.out.println("Original array: ");
            printArray(arr2);
            System.out.println("My partition result: ");
            printArray(arr1);
            System.out.println("==========================================");
        }
    }
}
