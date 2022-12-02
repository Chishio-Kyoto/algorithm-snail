package practice.sample1122;

import java.util.HashMap;
import java.util.Map;

public class Sample {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcabcbb";
        int result = solution.noRepeatStrLength(str);
        System.out.println(result);

        Solution1 solution1 = new Solution1();
        int result1 = solution1.noRepeatStrLength(str);
        System.out.println(result1);
    }

    /**
     * 暴力解法
     * 备注：contains本身有时间复杂度，可以考虑用哈希表存储已扫描的字符
     */
    static class Solution {
        public int noRepeatStrLength(String s) {
            int sLength = s.length();
            int result = 0;
            for (int i = 0; i < sLength; i++) {
                StringBuilder temp = new StringBuilder(s.charAt(i) + "");
                int count = 1;
                for (int j = i+1; j < sLength; j++) {
                    if (temp.toString().contains(String.valueOf(s.charAt(j)))) {
                        break;
                    } else {
                        temp.append(s.charAt(j));
                        count++;
                    }
                }
                result = Math.max(count, result);
            }
            return result;
        }
    }

    /**
     * 滑动窗口
     */
    static class Solution1 {
        public int noRepeatStrLength(String s) {
            int sLength = s.length();
            int start = 0, result = 0;
            int[] mark = new int[128];  // ascii码
            for (int j = start; j < sLength; j++) {
                if (mark[s.charAt(j)] - 1 >= start) {
                    result = Math.max(result, j - start);
                    start = mark[s.charAt(j)];  // 重置指针
                }
                mark[s.charAt(j)] = j + 1;
            }
            return Math.max(result, s.length() - start);
        }
    }
}
