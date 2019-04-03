package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyProducerConsumer {
    public static void main(String[] args) {
        // 生产者消费者的缓冲区
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        Thread producer1 = new Producer(buffer, maxSize, "producer1");
        Thread producer2 = new Producer(buffer, maxSize, "producer2");
        Thread consumer1 = new Consumer(buffer, maxSize, "consumer1");
        Thread consumer2 = new Consumer(buffer, maxSize, "consumer2");
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}

class Producer extends Thread {
    private Queue<Integer> buffer;
    private int maxSize;
    private Random random = new Random();

    public Producer(Queue<Integer> buffer, int maxSize, String name) {
        super(name);
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        // 一直会尝试去抢buffer的对象锁
        while (true) {
            synchronized (buffer) {
                // 进入了synchronized代码区则表明已经抢到了锁
                // 缓冲区为满，放不下
                while (buffer.size() == maxSize) {
                    System.out.println("Buffer is full, cannot produce!");
                    // 生产者释放锁，等待被notify
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 随便生产一个10以内的数放入缓冲区
                int tmp = random.nextInt(10);
                buffer.add(tmp);
                System.out.print(this.getName() + " produces value : " + tmp + ", size of buffer = " + buffer.size() + ", buffer = ");
                for (Integer i : buffer) {
                    System.out.print(i + ",");
                }
                System.out.println();
                // 唤醒在wait的线程，准备释放buffer对象锁
                buffer.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {
    private Queue<Integer> buffer;
    private int maxSize;

    public Consumer(Queue<Integer> buffer, int maxSize, String name) {
        super(name);
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        // 一直尝试去抢buffer的对象锁
        while (true) {
            synchronized (buffer) {
                // 进入了synchronized代码区则表明已经抢到了锁
                while (buffer.isEmpty()) {
                    System.out.println("Buffer is empty, cannot consume!");
                    // 消费者线程被阻塞，释放锁
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 从末端消费一个
                System.out.print(this.getName() + " consumes value : " + buffer.remove() + ", size of buffer = " + buffer.size() + ", buffer = ");
                for (Integer i : buffer) {
                    System.out.print(i + ",");
                }
                System.out.println();
                // notify在wait的被阻塞的线程，准备释放buffer对象锁
                buffer.notifyAll();
            }
        }
    }
}