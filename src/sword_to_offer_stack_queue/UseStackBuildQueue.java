package sword_to_offer_stack_queue;

import java.util.Stack;

public class UseStackBuildQueue {
    // 用栈实现队列结构
    // 准备两个栈，一个push栈，一个pop栈
    // 加数据入push栈,取数据从pop栈中拿
    // 总体思路是进push的数据倒入pop栈中，两次逆序等于顺序
    // 倒的两个限制：
    // 1) 如果push开始往pop中倒数据，一次要倒完
    // 2) pop栈不为空，不允许倒数据
    // 只要满足以上两个限制，倒数据的行为可以发生在任何时刻
    public static class TwoStackToQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackToQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        private void takeOutData() {
            // 2) pop栈不为空，不允许倒数据
            if (!stackPop.isEmpty())
                return;
            // 1) 如果push开始往pop中倒数据，一次要倒完
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        public void add(int num) {
            stackPush.push(num);
            takeOutData();
        }

        public int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            takeOutData();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            takeOutData();
            return stackPop.peek();
        }

    }
    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue = new TwoStackToQueue();
        twoStackToQueue.add(1);
        twoStackToQueue.add(3);
        twoStackToQueue.add(5);
        //twoStackToQueue.add(7);

        System.out.println("poll(): " + twoStackToQueue.poll());
        System.out.println("poll(): " + twoStackToQueue.poll());
        System.out.println("poll(): " + twoStackToQueue.poll());
        //System.out.println("poll():" + twoStackToQueue.poll());
    }
}
