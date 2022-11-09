package practice.sample1109;

public class Sample001 {
    public static void main(String[] args) {
        int dividend1 = 11, dividend2 = 101;
        int divisor1 = 2, divisor2 = 3;
        Solution solution = new Solution();
        int result1 = solution.divide(dividend1, divisor1);
        int result2 = solution.divide(dividend2, divisor2);
        System.out.println(result1);
        System.out.println(result2);
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int flag = 2;
        if (dividend > 0) {
            flag--;
            dividend = - dividend;
        }
        if (divisor > 0) {
            flag--;
            divisor = -divisor;
        }

        int result = dividendCore(dividend, divisor);
        return flag == 1 ? -result:result;
    }

    private int dividendCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                value += value;
                quotient += quotient;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}