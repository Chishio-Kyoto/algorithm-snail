package sample.ints;

import java.util.Arrays;

public class Sample005 {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "abcw", "foo", "bar", "fxyz",
                "abcdef", "abcw"
        };
        int result = maxProduct(strings);
        System.out.println(result);
    }

    public static int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch: words[i].toCharArray()) {
                // c - 'a' 的取值范围为0～25
                int ta = flags[i];
                int tb = 1 << (ch-'a');
                int tc = flags[i] | 1 << (ch-'a');
                flags[i] |= 1 << (ch-'a');
            }
        }
        System.out.println(Arrays.toString(flags));

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
