package array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public static void main(String[] args) {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        int[] nums2 = {2,2};
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(nums1));
        System.out.println(solution.findDisappearedNumbers(nums2));

        System.out.println(solution.findDisappearedNumbers2(nums1));
        System.out.println(solution.findDisappearedNumbers2(nums2));
    }

    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int[] count = new int[nums.length+1];
            for (Integer num: nums
                 ) {
                ++count[num];
            }
            for (int i = 1; i < count.length; i++) {
                if (count[i] == 0) {
                    result.add(i);
                }
            }
            return result;
        }

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // 将nums中的数-1后归类到0～n-1中
                int x = (nums[i] - 1) % n;
                // 在原来的值上+n，出现m次就加m个n
                nums[x] = nums[x] + n;
            }
            for (int i = 0; i < n; i++) {
                // 凡是出现过的，都大于n
                if (nums[i] <= n) {
                    result.add(i+1);
                }
            }
            return result;
        }
    }
}
