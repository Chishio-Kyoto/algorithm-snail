package practice.sample1202;

import java.util.HashMap;
import java.util.Map;

public class Sample002 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        long s1 = System.nanoTime();
        int r1 = coinChange01(coins, amount);
        long e1 = System.nanoTime();
        System.out.println(r1);
        System.out.println("程序运行时间: " + (e1 - s1) + "ns");  // 160087ns

        long s2 = System.nanoTime();
        int r2 = coinChange02(coins, amount);
        long e2 = System.nanoTime();
        System.out.println(r2);
        System.out.println("程序运行时间: " + (e2 - s2) + "ns");  // 53547ns

        long s3 = System.nanoTime();
        int r3 = coinChange03(coins, amount);
        long e3 = System.nanoTime();
        System.out.println(r3);
        System.out.println("程序运行时间: " + (e3 - s3) + "ns");  // 3730ns
    }

    public static int coinChange01(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private static int dp(int[] coins, int amount) {
        if (amount < 0) return 0;
        if (amount == 0) return -1;
        int result = Integer.MAX_VALUE;
        for (int coin: coins) {
            int temp = dp(coins, amount-coin);
            if (temp == -1) {
                continue;
            }
            result = Math.min(result, temp+1);
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    public static int coinChange02(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return dpPlus(coins, amount, map);
    }

    private static int dpPlus(int[] coins, int amount, Map<Integer, Integer> map) {

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        if (amount < 0) return 0;
        if (amount == 0) return -1;
        int result = Integer.MAX_VALUE;
        for (int coin: coins) {
            int temp = dpPlus(coins, amount-coin, map);
            if (temp == -1) {
                continue;
            }
            result = Math.min(result, temp+1);
        }

        map.put(amount, result != Integer.MAX_VALUE ? result : -1);
        return map.get(amount);
    }

    // dp数组的迭代写法
    public static int coinChange03(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount+1;
        }

        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin: coins) {
                if ((i - amount) < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1+ dp[i-coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
