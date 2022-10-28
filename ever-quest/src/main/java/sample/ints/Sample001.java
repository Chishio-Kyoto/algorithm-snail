package sample.ints;

public class Sample001 {
    public static void main(String[] args) {
        int q1 = divide(15, 2);
        int q2 = divide(0x80000000, -1);
        int q3 = divide(3000, 7);
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    private static int divideCore(int dividend, int divisor){
        int result = 0;
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
