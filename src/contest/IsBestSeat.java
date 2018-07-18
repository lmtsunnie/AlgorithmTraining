package contest;

import java.util.Scanner;

public class IsBestSeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            String x = sc.next();
            boolean res = isBestSeat(s, x);
            if (res) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }

    public static boolean isBestSeat(String s, String x) {
        if (s.contains(x) && isContainAll(s, x)) {
            return true;
        }
        return false;
    }

    public static boolean isContainAll(String s, String x) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            flag = false;
            for (int j = 0; j < x.length(); j++) {
                if (s.charAt(i) == x.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
