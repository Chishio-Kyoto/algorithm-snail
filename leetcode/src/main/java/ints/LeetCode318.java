package ints;

public class LeetCode318 {
    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        Solution solution = new Solution();
        int result = solution.maxProduct(words);
        System.out.println(result);

        Solution2 solution2 = new Solution2();
        int result2 = solution2.maxProduct(words);
        System.out.println(result2);
    }
}

class Solution {
    public int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                flags[i][c-'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}

class Solution2 {
    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch: words[i].toCharArray()) {
                flags[i] = flags[i] | (1 << (ch-'a'));
            }
            System.out.println(Integer.toBinaryString(flags[i]));
        }

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