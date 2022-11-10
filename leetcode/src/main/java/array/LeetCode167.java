package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode167 {
    public static void main(String[] args) {
        int[] numbers = {1,2,4,6,10};
        int[] numbers2 = {0,0,3,4};
        int target = 8;
        int target2 = 0;
        Solution solution = new Solution();
        int[] result1 = solution.twoSumA(numbers, target);
        System.out.println(Arrays.toString(result1));

        int[] result2 = solution.twoSumB(numbers, target);
        System.out.println(Arrays.toString(result2));

        int[] result3 = solution.twoSumC(numbers, target);
        System.out.println(Arrays.toString(result3));

        int[] result5 = solution.twoSumC(numbers2, target2);
        System.out.println(Arrays.toString(result5));

        int[] result4 = solution.twoSumD(numbers, target);
        System.out.println(Arrays.toString(result4));
    }

    static class Solution {
        // O(n^2)：暴力解法
        public int[] twoSumA(int[] numbers, int target) {
            int[] result = new int[2];
            int numbersLength = numbers.length;
            for (int i = 0; i < numbersLength-1; i++) {
                int temp = numbers[i];
                for (int j = i+1; j < numbersLength; j++) {
                    if (target - numbers[j] == temp) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
            return result;
        }

        // O(n*log(n))：二分法优化
        public int[] twoSumB(int[] numbers, int target) {
            int[] result = new int[2];
            int numbersLength = numbers.length;

            for (int i = 0; i < numbersLength-1; i++) {
                int low = i+1;
                int high = numbersLength-1;

                int temp = numbers[i];

                while (low <= high) {
                    int mid = low + ((high - low) >> 1);
                    if (numbers[mid] == target - temp) {
                        result[0] = i;
                        result[1] = mid;
                        break;
                    } else if (numbers[mid] < target - temp) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return result;
        }

        // O(n)：哈希表之空间换时间
        public int[] twoSumC(int[] numbers, int target) {
            int[] result = new int[2];
            int numbersLength = numbers.length;

            // 逐一放入哈希表
            List<Integer> list = new ArrayList<>();
            for (int ele: numbers) {
                list.add(ele);
            }
            int target1 = 0, target2 = 0;
            for (int i = 0; i < numbersLength; i++) {
                if (list.contains(target - list.get(i))) {
                    target1 = list.get(i);
                    target2 = target - list.get(i);
                    break;
                }
            }
            for (int i = 0; i < numbersLength; i++) {
                if (numbers[i] == target1) {
                    result[0] = i;
                    break;
                }
            }

            for (int i = numbersLength-1; i >= 0; i--) {
                if (numbers[i] == target2) {
                    result[1] = i;
                    break;
                }
            }
            return result;
        }

        // O(n)
        public int[] twoSumD(int[] numbers, int target) {
            int numbersLength = numbers.length;
            int i = 0;
            int j = numbersLength - 1;
            while (i < j && numbers[i] + numbers[j] != target) {
                if (numbers[i] + numbers[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return new int[] {i, j};
        }
    }
}
