package array;

public class TryCatchTest {
    public static int tryCatchTest() {
        try {
            // System.exit(0);
            System.out.println("try");
            return 1;
        } catch (RuntimeException e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
            return 2;
        }
    }

    public static String test11() {
        try {
            System.out.println("try block");
            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");
        return "after return";
    }

    public static void main(String[] args) {
        // System.out.println(tryCatchTest());
        System.out.println(test11());
    }
}
