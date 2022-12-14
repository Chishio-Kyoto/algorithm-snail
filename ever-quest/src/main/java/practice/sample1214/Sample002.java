package practice.sample1214;

import java.util.*;

public class Sample002 {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strings);
        System.out.println(result);
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // key：已排序的字符串数组、value:变位词组
            Map<String, List<String>> groups = new HashMap<>();
            for (String str: strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sorted = new String(charArray);
                groups.putIfAbsent(sorted, new LinkedList<String>());
                groups.get(sorted).add(str);
            }
            return new LinkedList<>(groups.values());
        }
    }
}
