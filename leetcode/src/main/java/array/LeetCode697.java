package array;

public class LeetCode697 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3,1};
        int[] nums2 = {1,2,2,3,1,4,2,3,4,3,5,3};
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(nums1));
        System.out.println(solution.findShortestSubArray(nums2));
    }

    static class Solution {
        public int findShortestSubArray(int[] nums) {
            int num_max = Integer.MIN_VALUE;
            int num_min = Integer.MAX_VALUE;
            for (int num: nums
                 ) {
                num_min = Math.min(num_min, num);
                num_max = Math.max(num_max, num);
            }
            int[] count = new int[num_max- num_min +1];
            int degree = 0;
            for (int num: nums
                 ) {
                degree = Math.max(degree, ++count[num - num_min]);
            }
            if (degree == 1) {
                return 1;
            }
            int result = nums.length;
            for (int i = 0; i < count.length; i++) {
                if (degree != count[i]) {
                    continue;
                }
                int temp = num_min + i;
                // 求该数出现的起始和结束的下标
                int start = 0, end = nums.length-1;
                while (start < end && temp != nums[start]) {
                    start++;
                }
                while (start < end && temp != nums[end]) {
                    end--;
                }
                result = Math.min(result, end - start + 1);
            }
            return result;
        }
    }
}


