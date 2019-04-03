package test;

public class Print1234 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printer.printOdd();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    printer.printEven();
                }
            }
        }).start();
    }
}

class Printer {
    private boolean flag = true;
    private int odd = 1;
    private int even = 2;

    /**
     * flag为true打印奇数
     */
    public synchronized void printOdd() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(odd);
        odd += 2;
        flag = false;
        this.notify();
    }

    /**
     * flag为false打印偶数
     */
    public synchronized void printEven() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(even);
        even += 2;
        flag = true;
        this.notify();
    }

}
