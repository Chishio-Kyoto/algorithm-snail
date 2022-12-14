package practice.sample1213;

public class sample001 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 5, 3, 8, 6, 10, 1, 5, 3, 11, 10, 2, 3, 4, 5, 3, 8, 6, 10, 1, 5, 3, 11, 10};
        long s1 = System.nanoTime();
        int r1 = practice01(nums1);
        long e1 = System.nanoTime();
        System.out.println("r1: " + r1);
        System.out.println("程序运行时间: " + (e1 - s1) + "ns");

        int[] nums2 = {2, 3, 4, 5, 3, 8, 6, 10, 1, 5, 3, 11, 10, 2, 3, 4, 5, 3, 8, 6, 10, 1, 5, 3, 11, 10};
        long s2 = System.nanoTime();
        int r2 = practice02(nums2);
        long e2 = System.nanoTime();
        System.out.println("r2: " + r2);
        System.out.println("程序运行时间: " + (e2 - s2) + "ns");
    }

    /**
     * 房屋偷盗问题
     * @param nums
     */
    public static int practice01(int[] nums) {
        // 处理单序列为空的情况
        if(nums.length == 0) {
            return 0;
        }
        // dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    /**
     * 房屋偷盗问题
     */
    public static int practice02(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        return Math.max(helper01(nums, nums.length-2), helper01(nums, nums.length-3) + nums[nums.length-1]);
    }

    // 计算到第i处的最大值 > 偷盗最大值
    public static int helper01(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }

        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(helper01(nums, i-1), helper01(nums, i-2) + nums[i]);
    }
}
