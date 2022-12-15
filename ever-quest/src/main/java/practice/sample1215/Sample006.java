package practice.sample1215;

public class Sample006 {
    public static void main(String[] args) {
        int a = 15, b = 2;
        Solution solution = new Solution();
        int r = solution.divide(a, b);
        System.out.println(r);
    }

    static class Solution {
        public int divide(int a, int b) {
            // 可能溢出的情况处理，只有一种情况，即-2^31/-1
            if (a == 0x80000000 && b == -1) {
                return Integer.MAX_VALUE;
            }

            // 正负数的处理
            int flag = 2;
            if (a > 0) {
                flag--;
                a = -a;
            }
            if (b > 0) {
                flag--;
                b = -b;
            }
            return flag == 1 ? -divideCore(a, b) : divideCore(a, b);
        }

        // 核心计算逻辑
        private int divideCore(int a, int b) {
            int result = 0;
            while (a <= b) {
                // 初始值
                int value = b;
                int quotient = 1;
                // value和a的边界值，value为-2^31的一半、a为2倍的value，即最大为-2^31
                while (value >= 0xc0000000 && a <= value + value) {
                    // 每一步，赏倍增、value值倍增
                    quotient += quotient;
                    value += value;
                }
                result += quotient;
                a -= value;
            }
            return result;
        }
    }
}
