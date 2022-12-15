package practice.sample1215;

import java.util.LinkedList;
import java.util.List;

public class Sample003 {
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
            for (int i = 0; i < p.length(); i++) {
                counts[p.charAt(i) - 'a'] ++;
            }

            // 该段代码优化空间大～
            for (int i = 0; i <= s.length()-p.length(); i++) {
                // 此步操作涉及复制，极大影响处理时间
                int[] countsTemp = counts.clone();
                for (int j = 0; j < p.length(); j++) {
                    countsTemp[s.charAt(i+j) - 'a'] --;
                }
                if (areAllZero(countsTemp)) {
                    result.add(i);
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
