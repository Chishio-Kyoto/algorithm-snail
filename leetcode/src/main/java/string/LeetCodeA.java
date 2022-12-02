package string;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeA {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = new Solution().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0, j = 0; j < s.length(); j++) {
                char r = s.charAt(j);
                // 使用哈希表记录不同的字符及对应出现的次数，默认值为0
                map.put(r, map.getOrDefault(r, 0) + 1);
                // 当某字母出现的次数大于1时
                while (map.get(r) > 1) {
                    // 获取前指针
                    char l = s.charAt(i);
                    // 重复字符个数重置为1，并删除之前的字符
                    map.put(l, map.get(l) - 1);
                    i++;
                }
                ans = Math.max(ans, j - i + 1);
            }
            return ans;
        }
    }
}
