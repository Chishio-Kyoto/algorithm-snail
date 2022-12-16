package practice.sample1216;

import java.util.Arrays;

public class Sample001 {
    public static void main(String[] args) {
        int n = 5;
        Solution solution = new Solution();
        int[] r = solution.countBits(n);
        System.out.println(Arrays.toString(r));
    }

    static class Solution {
        public int[] countBits(int n) {
            // 整数 i 的二进制形式中 1 的个数比i & (i-1)的二进制形式中 1 的个数多 1。
            // 前n个数，含0，则总数为n+1
            int[] result = new int[n+1];
            for (int i = 0; i <= n; i++) {
                int j = i;
                while (j != 0) {
                    result[i] ++;
                    j = j & (j - 1);
                }
            }
            return result;
        }
    }
}
