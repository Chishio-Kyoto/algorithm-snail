package practice.sample1202;

public class Sample001 {
    public static void main(String[] args) {
        // 斐波那契数列：1、1、2、3、5、8、11...
        long s1 = System.nanoTime();
        int r1 = fib(30);
        long e1 = System.nanoTime();
        System.out.println(r1);
        System.out.println("程序运行时间: " + (e1 - s1) + "ns");  // 3395679ns

        long s2 = System.nanoTime();
        int r2 = fibPlus(30);
        long e2 = System.nanoTime();
        System.out.println(r2);
        System.out.println("程序运行时间: " + (e2 - s2) + "ns");  // 8844ns

        long s3 = System.nanoTime();
        int r3 = fibPlusPlus(30);
        long e3 = System.nanoTime();
        System.out.println(r3);
        System.out.println("程序运行时间: " + (e3 - s3) + "ns");  // 3762ns

    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }

    // 优化：解决重复计算
    public static int fibPlus(int n) {
        if (n == 0) return 0;
        // 使一个数组记录已经计算过的值
        int[] memo = new int[n+1];
        return helper(memo, n);
    }

    private static int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        // 处理已经计算过的值
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n-1) + helper(memo, n-2);
        return memo[n];
    }

    // dp 数组的迭代解法
    public static int fibPlusPlus(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
