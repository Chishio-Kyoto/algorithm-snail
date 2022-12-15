package practice.sample1215;

public class Sample001 {
    public static void main(String[] args) {
        String s1 = "abcdxabcde", s2 = "abcdeabcdx";
        Solution solution = new Solution();
        boolean r = solution.checkInclusion(s1, s2);
        System.out.println(r);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {

            if (s2.length() < s1.length()) return false;

            int[] counts = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                counts[ch - 'a'] += 1;
            }

            for (int i = 0; i <= s2.length()-s1.length(); i++) {

                int[] countsCopy = counts.clone();
                String str = s2.substring(i, i+s1.length());
                if (areAllZero(str, countsCopy)) {
                    return true;
                };
            }

            return false;
        }

        private boolean areAllZero(String str, int[] counts) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                counts[ch - 'a'] -= 1;
            }

            for (int count: counts) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
