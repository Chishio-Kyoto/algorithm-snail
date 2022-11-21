package everquest001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15}, nums2 = {3,2,4,15};
        int target1 = 9, target2= 6;
        Solution solution = new Solution();
        int[] result1 = solution.twoSum(nums1, target1);
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int t) {
            int numsLength = nums.length;
            // key:value  数值:对应的下标
            Map<Integer, Integer> map = new HashMap<>();
            // 链表不一定按数组顺序存储
            for (int i = 0; i < numsLength; i++) {
                map.put(nums[i], i);
            }
            System.out.println(map);
            for (int i = 0; i < numsLength; i++) {
                int a = nums[i], b = t - a;
                // 对已经处理过的数据及时删除
                if (map.get(a) == i) {
                    map.remove(a);
                }
                if (map.containsKey(b)) {
                    return new int[]{i, map.get(b)};
                }
            }
            return new int[]{};
        }
    }

    static class Solution2 {
        public int[] twoSum(int[] nums, int t) {
            int numsLength = nums.length;
            // key:value  数值:对应的下标
            Map<Integer, Integer> map = new HashMap<>();
            // 链表不一定按数组顺序存储
            System.out.println(map);
            for (int i = 0; i < numsLength; i++) {
                int a = nums[i], b = t - a;
                // 优化，减少哈希表的插入和删除操作
                if (map.containsKey(b)) {
                    return new int[]{i, map.get(b)};
                }
                map.put(a, i);
            }
            return new int[]{};
        }
    }
}
