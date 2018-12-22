package practice;

import java.util.*;

public class NowCoder {
    /**
     * 打印对象
     * @param index
     * @param obj
     */
    public static void print(int index, Object obj) {
        System.out.println(String.format("{%d}, %s", index, obj.toString()));
    }

    public static void demoString() {
        String str = "aAbB";
        print(1, str.charAt(0));
        print(2, str.codePointAt(0));
        print(3, str.codePointBefore(1));
        print(4, str.codePointCount(1,2));
        print(5, str.compareTo("aa"));
        print(6, str.charAt(1) - "aa".charAt(1));
        print(7, str.compareTo("aA"));
        print(8, str.compareTo("aAbBc"));
        print(9, str.compareToIgnoreCase("aabb"));
        print(10, str.concat("cc"));
        print(11, str.contains("aA"));
        print(12, str.contentEquals(new StringBuffer("aAbB")));
        print(13, "hello world love u".split(" "));
        Arrays.stream("hello world love u".split(" "))
                .filter(e -> !e.equals("world"))
                .forEach(System.out::println);
    }

    public static void demoMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; ++i) {
            map.put(String.valueOf(i), String.valueOf((int)Math.pow(i,2)));
        }
        print(1, map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(2, entry.getKey() + ":" + entry.getValue());
        }
        print(3, map.keySet());
        print(4, map.values());
        print(5, map.containsKey("1"));
        print(6, map.get("2"));
        map.replace("2", "A");
        print(7, map);
    }

    public static void demoList() {
        int[] arr = new int[]{1,3,4,5};
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            list.add(String.valueOf(i*i));
        }
        list.add(String.valueOf(3));
        list.add(String.valueOf(5));
        print(1, list);
        Collections.sort(list);
        print(2, list);
        Collections.reverse(list);
        print(3, list);
    }


    public static void main(String[] args) {
        //demoString();
        //demoMap();
        demoList();


    }

}
