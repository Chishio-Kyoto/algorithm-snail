package array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {
    public static void main(String[] args) {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        int[] nums2 = {2,2};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicates(nums1));
        System.out.println(solution.findDuplicates(nums2));
    }

    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                // num-1 > 0-n-1
                if (nums[num-1] > 0) {
                    nums[num-1] *= -1;
                } else {
                    list.add(num);
                }
            }
            return list;
        }
    }
}
