package test;

public class PrintABAB {
    public static void main(String[] args) {
        final PrinterAB printer = new PrinterAB();
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    print.printA();
                }
            }
        }).start();
         */

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printer.printA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printer.printB();
                }
            }
        }).start();
    }
}

class PrinterAB {
    private boolean flag = true;

    /**
     * 当flag为true才打印A，如果flag不满足，则拿到了锁也只能释放
     */
    public synchronized void printA() {
        // 进入非静态的synchronized方法则拿到this对象锁
        // flag为false进入循环阻塞，为true则跳过循环打印A
        while (!flag) {
            try {
                // 释放锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("A");
        // flag由true修改为false
        flag = false;
        // 唤醒阻塞的线程，准备释放this对象锁
        this.notify();
    }

    /**
     * 当flag为false才打印B
     */
    public synchronized void printB() {
        // 进入非静态的synchronized则拿到this对象锁
        // flag为true进入循环阻塞，为false跳过循环打印B
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("B");
        flag = true;
        this.notify();
    }
}
