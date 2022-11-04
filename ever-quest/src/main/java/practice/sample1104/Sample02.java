package practice.sample1104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sample02 {
    public static void main(String[] args) {
        int[][] intervals = {{8, 10}, {1, 3}, {2, 6}, {15,18}};
        Solution solution = new Solution();
        int[][] result = solution.merge(intervals);
        for (int[] temp: result) {
            System.out.println(Arrays.toString(temp));
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {

            List<int[]> list = new ArrayList<>();
            if(intervals.length == 0){
                return new int[0][2];
            }

            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            for(int i = 0; i < intervals.length; i++){
                int left = intervals[i][0], right = intervals[i][1];
                if(i == 0 || list.get(list.size() - 1)[1] < left){
                    list.add(new int[]{left, right});
                } else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
