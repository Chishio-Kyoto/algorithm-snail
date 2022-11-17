package array;

public class LeetCode713 {
    public static void main(String[] args) {
        int target = 100;
        int[] nums = { 10, 5, 2, 6 };
        Solution solution = new Solution();
        int result = solution.numSubarrayProductLessThanK(nums, target);
        System.out.println(result);
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // 乘积
            int product = 1;
            // 左指针
            int left = 0;
            // 子数组长度
            int count = 0;
            for (int right = 0; right < nums.length; right++) {
                product *= nums[right];
                while (left <= right && product >= k) {
                    product /= nums[left++];
                }
                count += right >= left ? right - left + 1 : 0;
            }
            return count;
        }
    }
}
