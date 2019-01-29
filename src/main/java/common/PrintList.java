package common;

import java.util.ArrayList;
import java.util.List;

public class PrintList {
    public static void printList(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[list.size()]);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        printList(arrayList);
    }
}
