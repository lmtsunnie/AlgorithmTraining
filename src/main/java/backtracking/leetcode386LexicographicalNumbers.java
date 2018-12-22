package backtracking;

import java.util.ArrayList;
import java.util.List;

import static format.PrintList.printList;

public class leetcode386LexicographicalNumbers {
    /*Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space.
The input size may be as large as 5,000,000.*/

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i ++) {
            dfs(list, n, i);
        }
        return list;
    }

    public static void dfs(List<Integer> list, int n, int cur) {
        if (cur > n) return;
        list.add(cur);
        for (int i = 0; i <= 9; i ++) {
            dfs(list, n, 10 * cur + i);
        }
    }

    public static void main(String[] args) {
        int n = 101;
        printList(lexicalOrder(n));
    }

}
