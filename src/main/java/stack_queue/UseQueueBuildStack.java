package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class UseQueueBuildStack {
    // 用队列结构实现栈结构
    // 准备两个队列，一个data队列，一个help队列
    // 压入数入data队列
    // 弹出数将data队列中的数除最后一个其他的压入help队列，将最后一个数返回用户，再将data和help引用互换
    /*public static class TwoQueueToStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueToStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int num) {
            data.add(num);
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }


        private void swap() {
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }
    }*/
    public static class TwoQueuesToStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesToStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public int push(int num) {
            data.add(num);
            return num;
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            // 注意：最后一个数要加回help中
            help.add(res);
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }
    }

    public static void main(String[] args) {
        TwoQueuesToStack twoQueuesToStack = new TwoQueuesToStack();
        twoQueuesToStack.push(1);
        twoQueuesToStack.push(3);
        twoQueuesToStack.push(5);
        //TwoQueuesToStack.push(7);

        System.out.println("peek():" + twoQueuesToStack.peek());
        System.out.println("pop(): " + twoQueuesToStack.pop());
        System.out.println("pop(): " + twoQueuesToStack.pop());
        System.out.println("pop(): " + twoQueuesToStack.pop());
        //System.out.println("pop():" + TwoQueuesToStack.pop());
    }
}
