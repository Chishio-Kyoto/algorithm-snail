package practice.sample1216;

public class Sample003 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        boolean r = solution.isPalindrome(s);
        System.out.println(r);
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                char ch1 = s.charAt(start);
                char ch2 = s.charAt(end);
                if (!Character.isLetterOrDigit(ch1)) {
                    start++;
                } else if (!Character.isLetterOrDigit(ch2)) {
                    end--;
                } else {
                    ch1 = Character.toLowerCase(ch1);
                    ch2 = Character.toLowerCase(ch2);
                    if (ch1 != ch2) {
                        return false;
                    }
                    start++;
                    end--;
                }
            }
            return true;
        }
    }
}
