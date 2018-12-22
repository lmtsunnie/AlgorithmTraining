package stack_queue;

public class UseArrayBuildArrayStack {
    // 固定数组实现栈
    // 准备一个变量index，数组的大小设置为栈的大小为initSize
    // 当要加一个数，index的含义为如果新来一个数，我把新来的数放在index位置
    // 当用户让我弹出一个数，我弹出的数是index的下面一个数
    // index == size时上一个数下标为size - 1,栈满，如还要压入给用户报错
    // index == 0时上一个数下标为-1.栈空，如还要弹出给用户报错
    /*public static class ArrayStack {
        private int[] arr;
        private int index;
        public int size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            this.size = initSize;
            arr = new int[initSize];
            index = 0;
        }

        public void push(int num) {
            if (index == this.size) {
                throw new ArrayIndexOutOfBoundsException("The ArrayStack is full");
            }
            arr[index++] = num;
        }

        public int pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The ArrayStack is empty");
            }
            return arr[--index];
        }

        public int peek() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The ArrayStack is empty");
            }
            return arr[index - 1];
        }
    }*/

    public static class ArrayStack {
        private int[] array;
        private int index;
        public int size; // 栈的大小，也是数组的大小

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            this.size = initSize;
            array = new int[initSize];
            index = 0;
        }

        public int push(int num) {
            if (index < size) {
                array[index ++] = num;
                return num;
            } else {
                throw new ArrayIndexOutOfBoundsException("The stack is full!");
            }
        }

        public int pop() {
            if (index > 0) {
                return array[-- index];
            } else {
                throw new ArrayIndexOutOfBoundsException("The stack is empty!");
            }
        }

        public int peek() {
            if (index > 0) {
                return array[index - 1];
            } else {
                throw new ArrayIndexOutOfBoundsException("The stack is empty!");
            }
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        //arrayStack.push(7);

        System.out.println("peek():" + arrayStack.peek());
        System.out.println("pop(): " + arrayStack.pop());
        System.out.println("pop(): " + arrayStack.pop());
        System.out.println("pop(): " + arrayStack.pop());
        //System.out.println("pop():" + arrayStack.pop());
    }
}
