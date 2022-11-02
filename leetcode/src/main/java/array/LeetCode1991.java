package array;

import java.util.Arrays;

public class LeetCode1991 {
    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        Solution solution = new Solution();
        int result = solution.pivotIndex(nums);
        System.out.println(result);
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 1) {
            return 0;
        }
        int[] numsSumFromLeftToRight = new int[numsLength];
        int[] numsSumFromRightToLeft = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            numsSumFromLeftToRight[i] = i == 0 ? nums[i] : numsSumFromLeftToRight[i-1] + nums[i];
        }

        for (int j = 0; j < numsLength; j++) {
            numsSumFromRightToLeft[j] = j == 0 ? nums[numsLength-1] : numsSumFromRightToLeft[j-1] + nums[numsLength-1-j];
        }
        System.out.println(Arrays.toString(numsSumFromLeftToRight));
        System.out.println(Arrays.toString(numsSumFromRightToLeft));

        int result = 0;
        boolean flag = false;
        for (int i=0; i<numsLength; i++) {
            if (numsSumFromLeftToRight[i] == numsSumFromRightToLeft[numsLength-1-i]) {
                result = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return result;
        } else {
            return -1;
        }
    }
}