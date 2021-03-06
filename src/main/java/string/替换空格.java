package string;

public class 替换空格 {
/*请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/

    /**
     * 自想1：使用函数
     */
    public static String replaceSpace1(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }
    /**
     * 自想2：长度延长替换
     *
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {
        int beforeLength = str.length();
        int space = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                space++;
            }
        }
        int afterLength = beforeLength + 2 * space;
        str.setLength(afterLength);
        int i = beforeLength - 1, j = afterLength - 1;
        while (i >= 0 && j >= 0) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(j--, str.charAt(i--));
            } else {
                str.setCharAt(j, '0');
                str.setCharAt(j - 1, '2');
                str.setCharAt(j - 2, '%');
                j = j - 3;
                i--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy");
        System.out.println(replaceSpace1(str));
        System.out.println(replaceSpace2(str));
    }
}
