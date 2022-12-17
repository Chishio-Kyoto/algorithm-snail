package practice.sample1216;

public class Sample004 {
    public static void main(String[] args) {
        String s = "abcdefkkfopqrstsrqpoz";
        Solution solution = new Solution();
        int r = solution.countSubstrings(s);
        System.out.println(r);
    }

    static class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) return 0;

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += countPalindrome(s, i, i);
                count += countPalindrome(s, i, i+1);
            }
            return count;
        }

        private int countPalindrome(String s, int start, int end) {
            int count = 0;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }
            return count;
        }
    }
}
