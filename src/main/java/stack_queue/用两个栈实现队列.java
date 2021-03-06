package stack_queue;

import java.util.Stack;

public class 用两个栈实现队列 {
    /*用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/

    /**
     * 用栈实现队列结构
     * 准备两个栈，一个push栈，一个pop栈
     * 加数据入push栈，取数据从pop栈中拿
     * 总体思路是进push的数据倒入pop栈中，两次逆序等于顺序
     * 倒的两个限制：
     * 1) 如果push开始往pop中倒数据，一次要倒完
     * 2) pop栈不为空，不允许倒数据
     * 只要满足以上两个限制，倒数据的行为可以发生在任何时刻
     */

    // push的栈
    Stack<Integer> stack1 = new Stack<>();
    // pop的栈
    Stack<Integer> stack2 = new Stack<>();

    public void transfer() {
        if (!stack2.isEmpty()) {
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public void push(int node) {
        stack1.push(node);
        transfer();
    }

    public int pop() {
        transfer();
        return stack2.pop();
    }
}
