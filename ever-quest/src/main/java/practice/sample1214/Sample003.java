package practice.sample1214;

import java.util.Arrays;

public class Sample003 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"offer", "is", "coming"};
        String order1 = "cbadefghijklmnopqrstuvwzyx";
        String order2 = "zyxwvuopqrsthijklmncbadefg";
        boolean r = solution.isAlienSorted(words, order2);
        System.out.println(r);
    }

    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            // 基于已知字母表的顺序将提供的order字母表顺序进行映射
            int[] orderArray = new int[26];
            for (int i = 0; i < order.length(); i++) {
                orderArray[order.charAt(i) - 'a'] = i;
            }

            // 逐个比较words中前后的两个字符串的顺序
            for (int i = 0; i < words.length - 1; i++) {
                if (!isSorted(words[i], words[i+1], orderArray)) {
                    return false;
                }
            }
            return true;
        }

        // 判断相邻的两个单词是否按照字母表的顺序排序
        private boolean isSorted(String word1, String word2, int[] order) {
            int i = 0;
            for (; i < word1.length() && i < word2.length(); ++i) {
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(i);

                // 逐个比较字符串中每个字符
                if (order[ch1 - 'a'] < order[ch2 - 'a']) {
                    System.out.println("@@ " + (ch1 - 'a'));
                    System.out.println("## " + (ch2 - 'a'));
                    return true;
                }

                if (order[ch1 - 'a'] > order[ch2 - 'a']) {
                    return false;
                }
            }
            // 已比较相同的字符串，短的在前
            return i == word1.length();
        }
    }
}
