package format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintDoubleArrayList {
    // 只能用于矩形二维数组，每行元素个数相同，每列元素个数也相同
    public static int[][] convertDoubleArrayListToDoubleArray(ArrayList<ArrayList<Integer>> arrayLists) {
        int[][] array = new int[arrayLists.size()][arrayLists.get(0).size()];
        int i = 0;
        for (ArrayList<Integer> arrayList : arrayLists) {
            int j = 0;
            for (Integer integer : arrayList) {
                array[i][j++] = integer;
            }
            i++;
        }
        return array;
    }

    public static void printDoubleArray(int[][] arrays) {
        for (int[] array : arrays) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void print1(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void print2(ArrayList<ArrayList<Integer>> arrayLists) {
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1,2,3));
        lists.add(Arrays.asList(4,5,6));
        lists.add(Arrays.asList(7,8,9));
        print1(lists);
        System.out.println("=======================================");

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        arrayLists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        arrayLists.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
        print2(arrayLists);
        System.out.println("======================================");

        printDoubleArray(convertDoubleArrayListToDoubleArray(arrayLists));
    }
}
