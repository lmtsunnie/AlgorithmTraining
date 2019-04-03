package test;

import java.util.Scanner;


public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] str = s.split(",");
            if ("Node".equals(str[0])) {
                System.out.println("True");
            }
            int[] nums = new int[str.length + 1];
            for (int i = 0; i < str.length && !("Node".equals(str[i])); i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            if (isBST(nums)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
            //printArray(nums);
        }
    }

    public static boolean isBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int i = 0, leftIndex = 2 * i + 1, rightIndex = leftIndex + 1;
        while (leftIndex <= nums.length - 1) {
            if (rightIndex <= nums.length - 1) {
                if (!(nums[leftIndex] < nums[i] && nums[rightIndex] > nums[i])) {
                    return false;
                }
            } else {
                if (!(nums[leftIndex] < nums[i])) {
                    return false;
                }
            }
            i++;
            leftIndex = 2 * i + 1;
            rightIndex = leftIndex + 1;
        }
        return true;
    }
}
