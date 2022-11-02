package practice.sample1102;

public class Sample001 {
    public static void main(String[] args) {
        int a = 1000, b = -3;
        int c = divide(a, b);
        System.out.println(c);
    }

    public static int divide(int dividend, int divisor) {
        // 处理dividend=-2^31,divisor=-1的情况
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = 2;
        if (dividend > 0) {
            flag--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            flag--;
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);
        return flag == 1 ? -result : result;
    }

    // dividend和divisor均处理为负数
    public static int divideCore(int dividend, int divisor) {
        // 如果dividend>divisor，商均为0
        int result = 0;
        // 如果dividend<=divisor，商取值范围为1～2^30
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
