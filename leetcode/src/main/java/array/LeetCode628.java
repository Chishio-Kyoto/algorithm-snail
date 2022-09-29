package array;

public class LeetCode628 {
    public static void main(String[] args) {
        int[] nums1 = {-100,-98,-1,2,3,4};
        int[] nums2 = {-1,-2,-3, -4};
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(nums1));
        System.out.println(solution.maximumProduct(nums2));
    }

    static class Solution {
        public int maximumProduct(int[] nums) {
            int max_first = Integer.MIN_VALUE;
            int max_second = Integer.MIN_VALUE;
            int max_three = Integer.MIN_VALUE;
            int min_first = Integer.MAX_VALUE;
            int min_second = Integer.MAX_VALUE;
            // 提示：-1000 <= nums[i] <= 1000。故不再考虑值为Integer.MAX_VALUE、Integer.MIN_VALUE的情况
            for (int num : nums) {
                if (num >= max_first) {
                    max_three = max_second;
                    max_second = max_first;
                    max_first = num;
                } else if (num >= max_second) {
                    max_three = max_second;
                    max_second = num;
                } else if (num >= max_three) {
                    max_three = num;
                }
                if (num <= min_first) {
                    min_second = min_first;
                    min_first = num;
                } else if (num <= min_second) {
                    min_second = num;
                }
            }
            return Math.max((max_first*max_second*max_three), (max_first*min_first*min_second));
        }
    }
}
