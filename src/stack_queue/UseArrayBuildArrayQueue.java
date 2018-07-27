package stack_queue;

public class UseArrayBuildArrayQueue {
    // 固定数组实现队列
    // 准备一个变量start变量一个end变量，一开始都指向0位置
    // 再准备一个size变量约束start和end的行为，size表示队列的大小
    // start和end无直接关系（解耦），start或者end都是每次和size比较是否越界
    // end代表当要加一个数，我把新来的数放在end位置
    // start代表当用户让我取出一个数，我取出的数是start位置的数给用户
    // 类似于加数队尾排队打饭，取数队头打完饭走人
    // end一旦到底就返回开头，start一直在追end
    // nonEmptySize == arr.length 时队列为满，如还要加数给用户报错
    // nonEmptySize == 0队列为空，如还要取数给用户报错
    public static class ArrayQueue {
        private int[] arr;
        private int nonEmptySize;
        private int start;
        private int end;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new int[initSize];
            nonEmptySize = 0;
            start = 0;
            end = 0;
        }

        public void add(int num) {
            if (nonEmptySize == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The ArrayQueue is full");
            }
            nonEmptySize++;
            arr[end] = num;
            // end的下一个位置
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public int poll() {
            if (nonEmptySize == 0) {
                throw new ArrayIndexOutOfBoundsException("The ArrayQueue is empty");
            }
            nonEmptySize--;
            int tmp = start;
            // start的下一个位置
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }

        public int peek() {
            if (nonEmptySize == 0) {
                throw new ArrayIndexOutOfBoundsException("The ArrayQueue is empty");
            }
            return arr[start];
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(3);
        arrayQueue.add(5);
        //arrayQueue.add(7);

        System.out.println("poll(): " + arrayQueue.poll());
        System.out.println("poll(): " + arrayQueue.poll());
        System.out.println("poll(): " + arrayQueue.poll());
        //System.out.println("poll():" + arrayQueue.poll());
    }
}
