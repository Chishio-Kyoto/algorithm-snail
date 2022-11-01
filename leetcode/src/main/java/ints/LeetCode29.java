package ints;

public class LeetCode29 {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = -1;
        Solution solution = new Solution();
        int result = solution.divide(dividend, divisor);
        System.out.println(result);
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend == 0x80000000 && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            int flag = 2;
            if(dividend > 0) {
                flag--;
                dividend = -dividend;
            }
            if(divisor > 0) {
                flag--;
                divisor = -divisor;
            }

            int result = divisionCore(dividend, divisor);
            return flag == 1 ? -result : result;
        }

        public int divisionCore(int dividend, int divisor) {
            int result = 0;
            // dividend > divisor的情况，商均为0
            while(dividend <= divisor) {
                int value = divisor;
                int quotient = 1;
                // 负数的最小值为0x80000000，其一半值为0xc0000000
                // 如果value < 0xc0000000，即在-2^31~-2^30，此时不论dividend值为多少，商在0或1
                // 如果value < 0xc0000000,value+value结果会溢出
                while(value >= 0xc0000000 && dividend <= value + value) {
                    quotient += quotient;
                    value += value;
                }
                result += quotient;
                dividend -= value;
            }
            return result;
        }
    }
}
