package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            if (nums.length >= 3) {
                // 对nums进行排序
                Arrays.sort(nums);

                int i = 0;
                // 对前nums.length - 2个元素进行处理
                while (i < nums.length - 2) {
                    // 求和计算：原数组、当前的i、result
                    twoSum(nums, i, result);
                    // 固定的值，则其余两个数的目标和固定，为-temp;
                    int temp = nums[i];
                    // 对于重复出现的值直接越过即可
                    while (i < nums.length && nums[i] == temp) {
                        ++i;
                    }
                }
            }
            return result;
        }

        private void twoSum(int[] nums, int i, List<List<Integer>> result) {
            // 采用双指针
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int temp = nums[j];
                    // 需要跳过相同的值，查询还在进行
                    while (nums[j] == temp && j < k) {
                        ++j;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
    }
}
