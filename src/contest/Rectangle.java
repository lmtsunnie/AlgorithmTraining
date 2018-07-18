package contest;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            long res = rectangle(x, y, z);
            System.out.println(res);
        }
        sc.close();
    }

    private static long rectangle(int x, int y, int z) {
        int a = 1;
        for (; a <= 10000; a++) {
            if (x % a != 0 || z % a != 0) {
                continue;
            }
            if (x * z / (a * a) == y) {
                break;
            }
        }
        return 4 * (a + x / a + z / a);
    }
}
