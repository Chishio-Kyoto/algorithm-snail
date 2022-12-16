package practice.sample1216;

import java.util.HashSet;

public class Sample002 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        Solution solution = new Solution();
        int r = solution.singleNumber(nums);
        System.out.println(r);

        int[] nums2 = {0,1,0,1,0,1,99};
        Solution solution2 = new Solution();
        int r2 = solution.singleNumberPlus(nums2);
        System.out.println(r2);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int[] bitSums = new int[32];
            for (int num : nums) {
                for (int i=0; i< 32; i++) {
                    bitSums[i] += (num >> (31 - i)) & 1;
                }
            }

            int result = 0;
            for (int i=0; i<32; i++) {
                result = (result << 1) + bitSums[i] % 3;
            }
            return result;
        }

        // 假设sum(nums)的值为3N+X，则3*sum(set(nums)) - sum(nums) = (3N+3X) - (3N+X) = 2X
        // 故 X =  (3*sum(set(nums)) - sum(nums)) / 2
        // 该计算方式没有考虑求和和乘积时的数据溢出情况
        public int singleNumberPlus(int[] nums) {
            HashSet<Integer> hashSet = new HashSet<>();
            int sumNums = 0, sumHashNums = 0;
            for (int num: nums) {
                sumNums += num;
                if (!hashSet.contains(num)) {
                    sumHashNums += num;
                }
                hashSet.add(num);
            }
            return (3*sumHashNums - sumNums) / 2;
        }
    }
}
