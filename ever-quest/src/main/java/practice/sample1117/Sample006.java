package practice.sample1117;

public class Sample006 {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        Solution solution = new Solution();
        int result = solution.pivotIndex(nums);
        System.out.println(result);
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int num: nums) {
                total += num;
            }
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum - nums[i] == total - sum) {
                    return i;
                }
            }
            return -1;
        }
    }
}
