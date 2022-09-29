package array;

public class LeetCode485 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,0,1,1,1};
        int[] nums2 = {1,0,1,1,0,1};
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(nums1));
        System.out.println(solution.findMaxConsecutiveOnes(nums2));
    }

    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;
            int temp = 0;
            for (int i: nums
                 ) {
                if (i == 1) {
                    temp++;
                } else {
                    result = Math.max(temp, result);
                    temp = 0;
                }
                result = Math.max(temp, result);
            }
            return result;
        }
    }
}
