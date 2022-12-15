package practice.sample1215;

import java.util.LinkedList;
import java.util.List;

public class Sample004 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        Solution solution = new Solution();
        List<Integer> r = solution.findAnagrams(s, p);
        System.out.println(r);
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> result = new LinkedList<>();

            if (p.length() > s.length()) {
                return result;
            }

            int[] counts = new int[26];
            int i = 0;
            for (; i < p.length(); i++) {
                counts[p.charAt(i) - 'a'] ++;
                counts[s.charAt(i) - 'a'] --;
            }

            if (areAllZero(counts)) {
                result.add(0);
            }

            for (; i < s.length(); i++) {
                counts[s.charAt(i) - 'a'] --;
                counts[s.charAt(i - p.length()) - 'a'] ++;
                if (areAllZero(counts)) {
                    result.add(i - p.length() + 1);
                }
            }
            return result;
        }

        private boolean areAllZero(int[] counts) {
            for (int count: counts) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
