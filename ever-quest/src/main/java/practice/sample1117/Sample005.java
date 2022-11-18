package practice.sample1117;

import java.util.HashMap;
import java.util.Map;

public class Sample005 {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        Solution solution = new Solution();
        int result = solution.findMaxLength(nums);
        System.out.println(result);
    }

    static class Solution {
        public int findMaxLength(int[] nums) {
            // 哈希表：key为前i个数字之和、value为对应的i
            Map<Integer, Integer> sumToIndex = new HashMap<>();
            sumToIndex.put(0, 0);
            int sum = 0;
            int maxLength = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] == 0 ? -1 : 1;
                if (sumToIndex.containsKey(sum)) {
                    maxLength = Math.max(maxLength, i-sumToIndex.get(sum));
                } else {
                    sumToIndex.put(sum, i);
                }
            }
            return maxLength;
        }
    }
}
