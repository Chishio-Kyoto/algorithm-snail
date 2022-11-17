package array;

public class LeetCode209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2,3,1,2,4,3 };
        Solution solution = new Solution();
        int result = solution.minSubArrayLen(target, nums);
        System.out.println(result);
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                // 左指针移动的条件
                while (left <= right && sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
}
