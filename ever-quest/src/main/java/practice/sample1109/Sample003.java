package practice.sample1109;

import java.util.Arrays;

public class Sample003 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] results = solution.countBits(10);
        System.out.println(Arrays.toString(results));
        System.out.println(7&6);  // 6 -> 2
        System.out.println(6&5);  // 4 -> 1
        System.out.println(4&3);  // 0 -> 0
    }

    static class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num+1];
            for (int i = 0; i <= num; i++) {
                result[i] = result[i & (i-1)] + 1;
            }
            return result;
        }
    }
}
