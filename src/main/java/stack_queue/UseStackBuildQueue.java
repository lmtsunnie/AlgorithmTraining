package stack_queue;

import java.util.Stack;

public class UseStackBuildQueue {

    /**
     *  用栈实现队列结构
     *      准备两个栈，一个push栈，一个pop栈
     *      加数据入push栈，取数据从pop栈中拿
     *      总体思路是进push的数据倒入pop栈中，两次逆序等于顺序
     *      倒的两个限制：
     *      1) 如果push开始往pop中倒数据，一次要倒完
     *      2) pop栈不为空，不允许倒数据
     *      只要满足以上两个限制，倒数据的行为可以发生在任何时刻
     */
    public static class twoStacksToQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        private void transfer() {
            // pop栈不为空，不允许倒数据
            if (!popStack.empty()) {
                return;
            }
            // 如果push开始往pop中倒数据，一次要倒完
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }

        public twoStacksToQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public boolean offer(int i) {
            pushStack.push(i);
            transfer();
            return true;
        }

        public int poll() {
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            transfer();
            return popStack.pop();
        }

        public int peek() {
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            transfer();
            return popStack.peek();
        }
    }
    public static void main(String[] args) {
        twoStacksToQueue twoStacksToQueue = new twoStacksToQueue();
        twoStacksToQueue.offer(1);
        twoStacksToQueue.offer(3);
        twoStacksToQueue.offer(5);
        //twoStackToQueue.add(7);

        System.out.println("poll(): " + twoStacksToQueue.poll());
        System.out.println("poll(): " + twoStacksToQueue.poll());
        System.out.println("poll(): " + twoStacksToQueue.poll());
        //System.out.println("poll():" + twoStackToQueue.poll());
    }
}
