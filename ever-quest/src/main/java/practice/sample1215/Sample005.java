package practice.sample1215;

import java.util.HashMap;

public class Sample005 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        Solution solution = new Solution();
        String r = solution.minWindow(s, t);
        System.out.println(r);
    }

    static class Solution {
        public String minWindow(String s, String t) {

            // 统计t字符串中各字符的个数
            HashMap<Character, Integer> charToCount = new HashMap<>();
            for (char ch: t.toCharArray()) {
                charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
            }

            int count = charToCount.size();
            // 双指针、目标索引
            int start = 0, end = 0, minStart = 0, minEnd = 0;
            int minLength = Integer.MAX_VALUE;
            while (end < s.length() || (count == 0 && end == s.length())) {
                // 未包含全部t的每一个字符时，end持续移动
                if (count > 0) {
                    char endCh = s.charAt(end);
                    if (charToCount.containsKey(endCh)) {
                        charToCount.put(endCh, charToCount.get(endCh) - 1);
                        if (charToCount.get(endCh) == 0) {
                            count--;
                        }
                    }
                    end++;
                } else {
                    // 已包含全部的t的每一个字符时，start持续移动，直到最短
                    // count为0，计算minLength并重置minStart、endStart
                    if (end - start < minLength) {
                        minLength = end - start;
                        minStart = start;
                        minEnd = end;
                    }
                    // 移动start指针
                    char startCh = s.charAt(start);
                    if (charToCount.containsKey(startCh)) {
                       charToCount.put(startCh, charToCount.get(startCh) + 1);
                       if (charToCount.get(startCh) == 1) {
                           count++;
                       }
                    }
                    start++;
                }
            }
            return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
        }
    }
}
