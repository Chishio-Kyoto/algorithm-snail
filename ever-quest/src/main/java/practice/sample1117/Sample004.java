package practice.sample1117;

import java.util.HashMap;
import java.util.Map;

public class Sample004 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        Map<Integer, Integer> result1 = test01(nums1);
        System.out.println(result1);
        int result2 = test02(nums1);
        System.out.println(result2);
    }

    public static Map<Integer, Integer> test01(int[] nums) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        for (int num: nums) {
            sum += num;
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return sumToCount;
    }

    public static int test02(int[] nums) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num: nums) {
            // 求和
            sum += num;
            // 统计前i个数字之和为sum - 2的次数
            // pre[j-1] = pre[i] - k;
            count += sumToCount.getOrDefault(sum - 2, 0);
            // 哈希表：key为前i个数字之和、value为该值出现的次数
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
