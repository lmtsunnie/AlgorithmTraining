package format;

public class Input {

    //数组常用
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            bubbleSort(arr);
            PrintArray(arr);
        }
        sc.close();
    }

    private static void PrintArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i ++) {
            System.out.Print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void transpose(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
// 注意i,j不能相等
    public static void transpose(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    */

    /*public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        // ...
        System.out.println(sum);
    }*/


//    输入第一行为字符串个数n(n ≤ 100)
//    接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
    /*public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i ++) {
                words[i] = scanner.next();
            }
            System.out.println(validate(words));
        }
        scanner.close();
    }*/


    // 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50)
    // 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
    /*public static void main(String[] args){    
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int times = 0;
            int n = scanner.nextInt();
            int[] inputArr = new int[n];
            for(int i = 0; i < n; i++) {
                inputArr[i] = scanner.nextInt();
            }
            // ...
        scanner.close();
    }
}*/


    //  不定长度数组的键盘输入
   /* public static int[] Input() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(" ");
        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i ++)
            a[i] = Integer.parseInt(str[i]);
        return a;
    }*/



}
