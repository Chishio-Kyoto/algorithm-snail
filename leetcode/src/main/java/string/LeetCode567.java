package string;

import java.util.Arrays;

public class LeetCode567 {
    public static void main(String[] args) {
        String s1 = "a", s2 = "a";
        Solution solution = new Solution();
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);
    }

    static class Solution {
        public boolean checkInclusion(String s, String t) {
            if (s.length() != t.length() || s.equals(t)) {
                return false;
            }
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }

    static class Solution1 {
        public boolean checkInclusion(String s, String t) {
            if (s.length() != t.length() || s.equals(t)) {
                return false;
            }
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            for (int count : counter) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
