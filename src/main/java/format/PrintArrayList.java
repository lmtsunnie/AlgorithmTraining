package format;

import java.util.ArrayList;

public class PrintArrayList {
    public static void printArrayList(ArrayList<Integer> arrayList) {
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        printArrayList(arrayList);
    }
}
