package sample.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Sample001 {
    public static void main(String[] args) {
        String s1 = "hello world~";
        char c1 = s1.charAt(2);
        System.out.println(c1);

        char[] chars = s1.toCharArray();
        chars[1] = 'a';
        String s2 = new String(chars);
        System.out.println(s2);

        String s3 = s2 + '~';
        System.out.println(s3);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "aaa");
        map.put(1, "ccc");
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
        map.putIfAbsent(1, "ddd");
        System.out.println(map);  // {0=aaa, 1=ccc}

        Queue<String> q = new LinkedList<>();
        q.add("a");
        q.add("b");
        q.offer("c");
        for (String s: q) {
            System.out.println(s);
        }
        System.out.println(q.peek());
    }
}
