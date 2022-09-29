package array;

public class LeetCode414 {
    public static void main(String[] args) {
        int[] test1 = {3, 2, 1};
        int[] test2 = {2, 2, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(test1));
        System.out.println(solution.thirdMax(test2));
    }
    static class Solution {
        public int thirdMax(int[] nums) {
            int result = nums[0];
            int numsLength = nums.length;
            if (numsLength == 1) {
                return result;
            }
            if (numsLength == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int nums_max = Integer.MIN_VALUE;
            int nums_middle = Integer.MIN_VALUE;
            int nums_min = Integer.MIN_VALUE;
            boolean flag = true;
            int count = 0;
            for (int num : nums) {
                if (num == Integer.MIN_VALUE && flag) {
                    count++;
                    flag = false;
                }
                if (num > nums_max) {
                    nums_min = nums_middle;
                    nums_middle = nums_max;
                    nums_max = num;
                    count++;
                } else if (num < nums_max && num > nums_middle) {
                    nums_min = nums_middle;
                    nums_middle = num;
                    count++;
                } else if (num < nums_middle && num > nums_min) {
                    nums_min = num;
                    count++;
                }
            }
            return count>=3 ? nums_min : nums_max;
        }
    }
}
