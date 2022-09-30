package array;

import java.util.Arrays;

public class LeetCode645 {
    public static void main(String[] args) {
        int[] nums1 = {4,2,2,1};
        int[] nums2 = {1,1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(nums1)));
        System.out.println(Arrays.toString(solution.findErrorNums(nums2)));
    }

    static class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] count = new int[nums.length+1];
            for (int num : nums) {
                count[num]++;
            }
            int[] result = new int[2];
            int countLength = count.length;
            for (int i = 0; i < countLength; i++) {
                if (count[i] > 1) {
                    result[0] = i;
                }
                if (count[i] < 1) {
                    result[1] = i;
                }
            }
            return result;
        }
    }
}
