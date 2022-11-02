package array;

public class LeetCodeX1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = solution.searchInsert(nums, target);
        System.out.println(result);
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target){
                    return mid;
                } else if (nums[mid] < target){
                    left = mid + 1;
                } else if (nums[mid] > target){
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
