package array;

import java.util.Arrays;

public class LeetCode41 {
    public static void main(String[] args) {
        int[] nums1 = {7,8,9,11,12};
        int[] nums2 = {2, 1};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums1));
        System.out.println(solution.firstMissingPositive(nums2));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            int result = 1;
            if (nums.length == 1) {
                if (nums[0] == 1) {
                    return 2;
                } else {
                    return 1;
                }
            }
            int[] count = new int[nums.length+1];
            for (int num: nums
            ) {
                if (num > 0 && num < (nums.length+1)) {
                    ++count[num];
                }
            }
            for (int i=1; i<nums.length+1; i++) {
                if (count[i]==0) {
                    result = i;
                    break;
                }
                result = i+1;
            }
            return result;
        }
    }
}
