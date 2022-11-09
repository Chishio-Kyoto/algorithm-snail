package practice.sample1109;

public class Sample004 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,100};
        Solution solution = new Solution();
        int result = solution.singleNumber(nums);
        System.out.println(result);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int[] bitsNumber = new int[32];
            for (int i = 0; i < 32; i++) {
                for (int num: nums) {
                    bitsNumber[i] = (num >> (31 - i)) & 1;
                }
            }
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result = (result<<1) + bitsNumber[i] % 3;
            }
            return result;
        }
    }
}
