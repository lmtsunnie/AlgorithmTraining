package stack_queue;

import java.util.Stack;

public class GetMinStack {
    // 实现一个栈，要求在普通栈的基础上加一个得到所有元素的最小值的函数getMin()，要求时间复杂度O(1)
    // 准备两个栈，data栈和min栈
    // 数据入data栈的同时，同步将min{min栈栈顶，即将压入data的当前数}压入min栈
    // min栈的栈顶就是所有数中的最小元素，data栈和min栈中同步入栈，同步出栈，保持个数一致
    public static class minStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public minStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        // 数据入data栈的同时，同步将min{min栈栈顶，即将压入data的当前数}压入min栈
        public void push(int num) {
            if (stackMin.isEmpty()) {
                stackMin.push(num);
            } else if (num < stackMin.peek()) {
                stackMin.push(num);
            } else {
                stackMin.push(stackMin.peek());
            }
            stackData.push(num);
        }

        // 弹栈你弹我也弹
        public int pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stackMin.peek();
        }

    }

    // 准备两个栈，data栈和min栈
    // 当入栈时只有当当前值比min栈栈顶小的时候才将当前值压入min栈
    // 当出栈时出栈的值和min栈栈顶比较，若相等则把min栈栈顶移除
    // 与minStack1相比节省min相同时的存储空间，每个min只存一份
    // 但是无法处理有元素相等的情况
    public static class minStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public minStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int num) {
            if (stackMin.isEmpty()) {
                stackMin.push(num);
            } else if (num < stackMin.peek()) {
                stackMin.push(num);
            }
            stackData.push(num);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            if (stackData.peek().equals(stackMin.peek())) {
                stackMin.pop();
            }
            return stackData.pop();
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        minStack1 minStack1 = new minStack1();
        minStack1.push(3);
        System.out.println(minStack1.getMin());
        minStack1.push(4);
        System.out.println(minStack1.getMin());
        minStack1.push(1);
        minStack1.push(1);
        System.out.println(minStack1.getMin());
        System.out.println(minStack1.pop());
        System.out.println(minStack1.getMin());

        System.out.println("=============");

        minStack2 minStack2 = new minStack2();
        minStack2.push(3);
        System.out.println(minStack2.getMin());
        minStack2.push(4);
        System.out.println(minStack2.getMin());
        minStack2.push(1);
        minStack2.push(1);
        System.out.println(minStack2.getMin());
        System.out.println(minStack2.pop());
        System.out.println(minStack2.getMin());
    }
}
