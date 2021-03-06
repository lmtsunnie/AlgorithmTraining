package array;

public class 旋转数组的最小数字 {
    /*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/

    /**
     * 参见二分查找变形总结的1.8
     * 时间复杂度O(logn)，空间复杂度O(1)
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // mid < hi，min在mid左边，有可能是mid
            if (array[mid] < array[hi]) {
                hi = mid;
                // mid > hi，min在mid的右边，不可能是mid
            } else if (array[mid] > array[hi]) {
                lo = mid + 1;
            } else {
                return array[mid];
            }
        }
        return 0;
    }
}
