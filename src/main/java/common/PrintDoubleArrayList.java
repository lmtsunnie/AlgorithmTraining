package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintDoubleArrayList {

    public static void printDoubleArray(int[][] arrays) {
        for (int[] array : arrays) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printDoubleList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printDoubleArrayList(ArrayList<ArrayList<Integer>> arrayLists) {
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // 这函数不好。。只能用于矩形二维数组，每行元素个数相同，每列元素个数也相同
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


    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1,2));
        lists.add(Arrays.asList(4,5,6));
        lists.add(Arrays.asList(7,8,9,10));
        printDoubleList(lists);
        System.out.println("=======================================");

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        arrayLists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        arrayLists.add(new ArrayList<Integer>(Arrays.asList(7,8)));
        printDoubleArrayList(arrayLists);
        System.out.println("======================================");

        printDoubleArray(convertDoubleArrayListToDoubleArray(arrayLists));


        System.out.println("======================================");
        List<List<Integer>> lists2 = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(1);
        tmpList.add(2);
        tmpList.add(3);
        //lists2.add(tmpList);
        lists2.add(new ArrayList<>(tmpList));

        tmpList.clear();

        tmpList.add(4);
        tmpList.add(5);
        //lists2.add(tmpList); 输出4545，因为后面tmpList改变了，只能把副本装进去，不能把自己装进去
        lists2.add(new ArrayList<>(tmpList));
        printDoubleList(lists2);
    }
}
