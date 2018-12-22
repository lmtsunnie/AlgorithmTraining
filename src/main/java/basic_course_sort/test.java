package basic_course_sort;

public class test {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int[] arr = new int[] {2,-5,9,2};
        System.out.println(smallSum(arr));
        /*while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(smallSum(arr));
        }
        scanner.close();*/
    }

    private static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            res = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
        }
        return res;
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int res = 0;
        int i = 0;
        int[] helper = new int[r - l + 1];
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            // p1指的数小才有小和
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p2越界
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        //p1越界
        while (p2 <= r) {
            helper[i++] = arr[p2++];
        }

        for (i = 0; i < helper.length; i++) {
            arr[l + i] = helper[i];
        }
        return res;
    }
}
