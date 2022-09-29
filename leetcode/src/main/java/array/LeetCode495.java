package array;

public class LeetCode495 {
    public static void main(String[] args) {
        int[] timeSeries = {1, 3, 6, 10, 11};
        int duration = 3;
        Solution solution = new Solution();
        System.out.println(solution.findPoisonedDuration(timeSeries, duration));
    }

    static class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int allDuration = 0;
            int timeSeriesLength = timeSeries.length;
            for (int i = 1; i < timeSeriesLength; i++) {
                allDuration += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
            }
            return allDuration + duration;
        }
    }
}
